
import java.io.*;
import java.lang.*;
import java.util.*;

public class AConvergence {
    
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
        Arrays.sort(arr);
        
        int[] l = new int[n];
        int[] r = new int[n];
        for(int i = 1; i<n;i++) {
            if(arr[i]==arr[i-1]) l[i] = l[i-1];
            else l[i] = i;
        }
        for(int i = n-2; i>=0; i--) {
            if(arr[i]==arr[i+1]) r[i] = r[i+1];
            else r[i] = n-i-1;
        }
        // System.out.println(Arrays.toString(l));
        // System.out.println(Arrays.toString(r));
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            res = Math.min(res, Math.max(l[i],r[i]));
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