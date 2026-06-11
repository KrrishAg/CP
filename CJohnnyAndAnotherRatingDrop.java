
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class CJohnnyAndAnotherRatingDrop {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        // for(int i = 1; i<100; i++) {
        //     int a = i-1, b = i;
        //     int cnt = 0;
        //     while(b>0) {
        //         if((b&1)!=(a&1)) cnt++;
        //         a>>=1;
        //         b>>=1;
        //     }
        //     System.out.println(cnt);
        // }

        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        long n = sc.nextLong();
        long ev, od;
        if((n&1)==0) {
            ev = od = n/2;
        }
        else {
            ev = n/2 + 1;
            od = n/2;
        }
        long res = ev + fn(od);
        System.out.println(res);
    }

    static long fn(long n) {
        if(n==0) return 0; 
        if(n==1) return 2; 
        
        if((n&(n-1))==0) {
            return 2*fn(n>>1) + 1;
        }
        else {
            long prev = 1;
            while(2*prev<n) {
                prev *= 2;
            }
            return fn(prev) + fn(n - prev);
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