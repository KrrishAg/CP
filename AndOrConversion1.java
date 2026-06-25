
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class AndOrConversion1 {
    
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
        char a[] = sc.next().toCharArray();
        char b[] = sc.next().toCharArray();
        for(int i = 0; i<n; i++) {
            a[i]-='0';
            b[i]-='0';
        }
        int change = 0;
        for(int i = 1; i<n; i++) {
            if(b[i]!=b[i-1]) change++;
        }
        int i = 0; 
        while(i<n && a[i]!=b[0]) i++;
        if(i==n) {
            System.out.println("No");
            return;
        }
        i++;
        int tmp = 0;
        for(; i<n; i++) {
            if(a[i]!=a[i-1]) tmp++;
        }
        if(tmp>=change) System.out.println("Yes");
        else System.out.println("No");
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