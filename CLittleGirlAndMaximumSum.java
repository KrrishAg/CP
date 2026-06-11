
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class CLittleGirlAndMaximumSum {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new long[n];
        input(arr);
        Arrays.sort(arr);
        int tmp[] = new int[n];
        for(int i = 0; i<q; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            tmp[a]++;
            if(b+1<n) tmp[b+1]--;
        }
        for(int i = 1; i<n; i++) tmp[i] += tmp[i-1];
        Arrays.sort(tmp);
        long res = 0;
        for(int i = 0; i<n; i++) {
            res += arr[i]*tmp[i];
        }
        System.out.println(res);
    }

    static void solve() throws IOException {
        
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