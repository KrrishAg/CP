
import java.io.*;
import java.lang.*;
import java.util.*;

public class AWeirdSum {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        solve();
    }

    static void solve() throws IOException {
        int n = sc.nextInt();    
        int m = sc.nextInt();    
        long mat[][] = new long[n+1][m+1];
        for(int i =1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                mat[i][j] = sc.nextLong();
            }
        }
        long res = 0;
        long row[][] = new long[100002][2];
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                long cur = mat[j][i];
                res = res + i*row[(int)cur][1] - row[(int)cur][0];

                row[(int)cur][0] += i;
                row[(int)cur][1]++;
            }
        }

        long col[][] = new long[100002][2];
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=m; j++) {
                long cur = mat[i][j];
                res = res + i*col[(int)cur][1] - col[(int)cur][0];

                col[(int)cur][0] += i;
                col[(int)cur][1]++;
            }
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