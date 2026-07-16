
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class C0MarAndAlternatingSums {
    
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
        long[] arr = new long[n];
        input(arr);
        long m1 = 0;
        HashMap<Long,Long> hm = new HashMap<>();
        for(long x:arr) {
            if(x==-1) m1++;
            hm.put(x,hm.getOrDefault(x,0L)+1);
        }
        long res = 1;
        for(long val:hm.values()) {
            res = (res * pow(2,val-1,MOD)) % MOD;
        }
        // System.out.println(res);
        if(m1==0) {
            System.out.println(res);
            return;
        }

        long tmp = res;
        res = (res - 1 + MOD)%MOD;
        // res = (res*2)%MOD;
        for(int i = 1; i<n; i++) {
            if(arr[i]-arr[i-1]==1) res = (res + tmp)%MOD;
        }
        res = (res+1)%MOD;
        System.out.println(res);

        //add 1 to res
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