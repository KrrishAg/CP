
import java.io.*;
import java.lang.*;
import java.util.*;

public class COmskProgrammers {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long x = sc.nextLong();
        
        long m = Long.MAX_VALUE;
        
        long aa = a;
        long tmpa = 0;
        
        while (true) {
            long bb = b;
            long tmpb = 0;
            
            while (true) {
                long curr = tmpa + tmpb + Math.abs(aa - bb);
                m = Math.min(m, curr);
                
                if (bb == 0) break;
                bb /= x;
                tmpb++;
            }
            
            if (aa == 0) break;
            aa /= x;
            tmpa++;
        }
        
        System.out.println(m);
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