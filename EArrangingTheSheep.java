
import java.io.*;
import java.lang.*;
import java.util.*;

public class EArrangingTheSheep {
    
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
        String s = sc.next();
        long lMov[] = new long[n];
        long rMov[] = new long[n];
        long lSheep[] = new long[n];
        long rSheep[] = new long[n];
        long prev = 0, ns = 0;
        for(int i = 0; i<n; i++) {
            prev+=ns;
            lMov[i] = prev;
            lSheep[i] = ns;
            if(s.charAt(i)=='*') ns++;
        }
        if(ns==0) {
            System.out.println(0);
            return;
        }
        prev = 0; ns = 0;
        for(int i = n-1; i>=0; i--) {
            prev+=ns;
            rMov[i] = prev;
            rSheep[i] = ns;
            if(s.charAt(i)=='*') ns++;
        }
        // System.out.println(Arrays.toString(lSheep));
        // System.out.println(Arrays.toString(rSheep));
        // System.out.println(Arrays.toString(lMov));
        // System.out.println(Arrays.toString(rMov));
        long res = Long.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            if(s.charAt(i)=='.') continue;
            long l = lMov[i] - (lSheep[i]*(lSheep[i]+1))/2;
            long r = rMov[i] - (rSheep[i]*(rSheep[i]+1))/2;
            // System.out.println(l+" "+r);
            res = Math.min(res,l+r);
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