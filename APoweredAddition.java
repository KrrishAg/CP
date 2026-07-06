
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class APoweredAddition {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    static ArrayList<Long> two = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        long x = 1;
        while(x<1e11+2) {
           two.add(x);
            x<<=1;
        }
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        long[] arr = new long[n];
        input(arr);
        ArrayList<Long> al = new ArrayList<>();
        al.add(arr[0]);
        int res = 0;
        long M = arr[0];
        for(int i = 1; i<n; i++) {
            if(arr[i]>M) M = arr[i];
            else {
                long curr = arr[i];
                int idx = 0, tmp = 0;
                while(curr<M) {
                    curr += two.get(idx++);
                    tmp++;
                }
                res = Math.max(res, tmp);
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