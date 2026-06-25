
import java.io.*;
import java.lang.*;
import java.util.*;

public class CLineEmpire {
    
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
        long a = sc.nextLong();    
        long b = sc.nextLong();    
        long arr[] = new long[n+1];
        for(int i = 1; i<=n; i++) {
            arr[i] = sc.nextLong();
        }
        long res = b*(arr[1]-arr[0]);
        int i = 0;
        while(i<=n-2) {
            long move = a*(arr[i+1]-arr[i]);
            long dnmove = b*(arr[i+1]-arr[i])*(n-i-1);
            // System.out.println(move+" "+dnmove);
            if(move<=dnmove) {
                res+=move;
                i++;
                res += b*(arr[i+1]-arr[i]);
                // System.out.println(move+" "+(b*(arr[i+1]-arr[i])));
            }
            else break;
            // System.out.println(res+"==");
        }
        // System.out.println(res);
        for(int j = i+2; j<=n; j++) {
            res += b*(arr[j]-arr[i]);
        }
        System.out.println(res);
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