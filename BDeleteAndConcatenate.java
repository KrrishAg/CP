
import java.io.*;
import java.lang.*;
import java.util.*;

public class BDeleteAndConcatenate {
    
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
        long c = sc.nextLong();
        long[] arr = new long[n];
        ArrayList<Long> sm = new ArrayList<>();
        ArrayList<Long> big = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            long x = sc.nextLong();
            if(x<c) sm.add(x);
            else big.add(x);
        }
        if(sm.size()<=big.size()) {
            long sum = 0;
            for(long x:big) sum+=x;
            System.out.println(sum - c*big.size());
        }
        else {
            Collections.sort(sm, Collections.reverseOrder());
            long sum = 0;
            for(long x:big) sum+=x;
            long extra = (sm.size()-big.size() + 1)/2;
            long cnt = big.size() + extra; 
            for(int i = 0; i<extra; i++) sum += sm.get(i);
            System.out.println(sum - c*cnt);
        }
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