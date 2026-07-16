
import java.io.*;
import java.lang.*;
import java.util.*;

public class EMashaAndTheGarland {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();
        int dp[] = new int[n];
        for(int i = 1; i<n; i++) {
            if(s.charAt(i)==s.charAt(i-1)) dp[i]++;
        }
        for(int i = 1; i<n; i++) dp[i] += dp[i-1];


        for(int i = 0; i<q; i++) {
            int l = sc.nextInt()-1;
            int r = sc.nextInt()-1;
            int k = sc.nextInt();
            int tmp = dp[r] - dp[l]; 

            if((tmp+1)/2<=k) System.out.println("YES");
            else System.out.println("NO");
        } 
    }


    // Array Inputs
    // Handle 1D array of integers
    static void input(int[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }
    
    // Handle 1D array of longs
    static void input(long[] arr) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLong();
        }
    }

    // FastScanner Class
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public float nextFloat() throws IOException {
            return Float.parseFloat(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }
    }
}