
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class BAndSequences {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        int m = Integer.MAX_VALUE;
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
            m = Math.min(x,m);
        }
        int bit[] = new int[32], idx = 0, mm = m;
        while(mm>0) {
            if((mm&1)==1) bit[idx] = 1;
            mm>>=1;
            idx++;
        }
        long cnt = 0;
        for(int x:arr) {
            if(x==m) cnt++;
            else {
                idx = 0;
                while(x>0) {
                    if(bit[idx]==1 && (x&1)==0) {
                        System.out.println(0);
                        return;
                    }
                    idx++;
                    x>>=1;
                }
            }
        }
        if(cnt==1) {
            System.out.println(0);
            return;
        }
        long res = 0;
        long middleFact = 1;
        for(int i = 1; i<=n-2; i++) {
            middleFact = (middleFact*i)%MOD;
        }
        long sides = (cnt*(cnt-1)) % MOD;
        System.out.println((sides*middleFact)%MOD);
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