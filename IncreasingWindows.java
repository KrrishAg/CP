
import java.io.*;
import java.lang.*;
import java.util.*;

public class IncreasingWindows {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 998244353;
    static int N = (int)2e5+5;
    static long fact[] = new long[N];
    
    public static void main(String[] args) throws IOException {
        fact[0] = 1;
        for(int i = 1; i<N; i++) {
            fact[i] = (fact[i-1]*i)%MOD;
        }

        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        long n = sc.nextLong();
        long k = sc.nextLong();
        long res = 0, prev = 0;
        for(int i = 0; i<=k; i++) {
            long a = i, b = n-i;
            long a_k = pow(a,k,MOD);
            long s = (a_k - prev + MOD)%MOD;
            long f = ((fact[(int)b] * pow(fact[(int)(n-k)], MOD-2, MOD) % MOD) * pow(fact[(int)(b-n+k)], MOD-2, MOD)) % MOD;
            res = (res + (s*f)%MOD)%MOD;
            prev = a_k;
            // System.out.println(res);
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