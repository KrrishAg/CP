
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class DYaroslavAndProductivity {
    
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
        int m = sc.nextInt();
        long[] arr = new long[n];
        input(arr);
        int[] indexes = new int[m];
        input(indexes);
        Arrays.sort(indexes);

        long ps[] = new long[n];
        ps[0] = arr[0];
        for(int i = 1; i<n; i++) ps[i] = ps[i-1] + arr[i];
        long dp[][] = new long[m][2];
        
        //last
        int idx = indexes[m-1]-1;
        dp[m-1][0] = ps[n-1];
        dp[m-1][1] = ps[n-1] - 2*ps[idx];
        
        for(int i = m-2; i>=0; i--) {
            idx = indexes[i]-1;
            dp[i][0] = Math.max(dp[i+1][0], dp[i+1][1] + 2*ps[idx]);                    
            dp[i][1] = Math.max(dp[i+1][1], dp[i+1][0] - 2*ps[idx]);                    
        }
        System.out.println(Math.max(dp[0][0], dp[0][1]));
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