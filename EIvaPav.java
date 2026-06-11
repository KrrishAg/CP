
import java.io.*;
import java.lang.*;
import java.util.*;

public class EIvaPav {
    
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
        int[] arr = new int[n+1];
        for(int i = 1; i<=n; i++) arr[i] = sc.nextInt();
        
        long cnt[][] = new long[n+1][32];
        for(int i = 1; i<=n; i++) {
            for(int j = 0; j<32; j++) {
                cnt[i][j] = cnt[i-1][j];
            }                
            int num = arr[i], bit = 0;
            while(num>0) {
                if((num&1)==1) cnt[i][bit]++;
                num >>= 1;
                bit++;
            }
        }

        // for(long x[]: cnt) System.out.println(Arrays.toString(x)); 

        int q = sc.nextInt();
        for(int i = 0; i<q; i++) {
            int l = sc.nextInt(), ll = l, r = n;
            int k = sc.nextInt();
            int res = -1;
            while(l<=r) {
                int mid = l+(r-l)/2;
                int curr = 0;

                for(int bit = 0; bit<32; bit++) {
                    if((cnt[mid][bit]-cnt[ll-1][bit]) == (mid-ll+1)) curr |= (1<<bit);
                }

                if(curr >= k) {
                    res = mid;
                    l = mid+1;
                }
                else r = mid-1;
                // System.out.println("i l r "+i+" "+l+" "+r);
            }
            System.out.print(res+" ");
        }
        System.out.println();
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