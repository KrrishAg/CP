
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class BTape {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        // int t = sc.nextInt();
        // while(t-->0) {
            solve();
        // }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        input(arr);
        long[] arr1 = new long[n-1];
        for(int i = 0; i<n-1; i++) {
            arr1[i] = arr[i+1] - arr[i] - 1;
        }
        Arrays.sort(arr1);
        long res = n;
        for(int i = 0; i<n-k; i++) {
            res+=arr1[i];
        }
        System.out.println(res);
    }

    static long pow(long base, long power, long m) {
       long res = 1;
       base %= m;
    
       while (power > 0) {
           if ((power & 1) == 1)
           res = (res * base) % m;
           base = (base * base) % m;
           power >>= 1;
       }
    
       return res;
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