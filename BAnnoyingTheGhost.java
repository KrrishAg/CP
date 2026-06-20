
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class BAnnoyingTheGhost {
    
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
        long[] a = new long[n];
        long[] b = new long[n];
        input(a);
        input(b);
        long res = 0;
        for(int i = 0; i<n; i++) {
            if(a[i]<=b[i]) continue;
            int j = i+1;
            while(j<n) {
                if(a[j]<=b[i]) break;
                else j++;
            }
            if(j==n) {
                System.out.println(-1);
                return;
            }
            res += j-i;
            for(; j>i; j--) {
                long tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
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