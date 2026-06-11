
import java.io.*;
import java.lang.*;
import java.util.*;

public class DFixedPointGuessing {
    
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

        int l = 1, r = n;
        while(l+1<r) {
            int mid = l+(r-l)/2;
            System.out.println("? "+l+" "+(mid-1));
            int cnt = 0;
            for(int i = l; i<mid; i++) {
                int x = sc.nextInt();
                if(x<l || mid<=x) cnt++;
            }
            if((cnt&1) == ((mid-l)&1)) l = mid;
            else r = mid-1; 
        }
        if(r-l==1) {
            System.out.println("? "+l+" "+l);
            int x = sc.nextInt();
            if(x==l) System.out.println("! "+l);
            else System.out.println("! "+r);
        }
        else System.out.println("! "+l);
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