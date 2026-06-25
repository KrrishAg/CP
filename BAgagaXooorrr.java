
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class BAgagaXooorrr {
    
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
        int[] arr = new int[n];
        input(arr);
        int[] a = new int[n];
        a[0] = arr[0];
        for(int i = 1; i<n; i++) a[i] = a[i-1]^arr[i];
        if(a[n-1]==0) {
            System.out.println("YES");
            return;
        }
        
        for(int i = 0; i<n-2; i++) {
            for(int j = i+1; j<n-1; j++) {
                if(a[i] == (a[j]^a[i]) && a[i] == (a[n-1]^a[j])) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
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