
import java.io.*;
import java.lang.*;
import java.util.*;

public class CTeaTasting {
    
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
        long[] amount = new long[n];
        long[] capacity = new long[n];
        input(amount);
        input(capacity);
        long[] prefixCapacity = new long[n+1];
        prefixCapacity[0] = capacity[0];
        for(int i = 1; i<n; i++) {
            prefixCapacity[i] += prefixCapacity[i-1] + capacity[i];
        }

        long cnt[] = new long[n+1];
        long res[] = new long[n+1];
        for(int i = 0; i<n; i++) {
            long amnt = amount[i];
            int ceil = n, l = i, r = n-1;
            while(l<=r) {
                int mid = l+(r-l)/2;
                long preSum = i==0 ? prefixCapacity[mid] : prefixCapacity[mid]-prefixCapacity[i-1];
                if(preSum>=amnt) {
                    ceil = mid;
                    r = mid-1;
                }
                else l = mid+1;
            }

            //update vals
            cnt[i]++;
            cnt[ceil]--;
            if(ceil>i) {
                if(i>0) amnt -= prefixCapacity[ceil-1]-prefixCapacity[i-1];
                else amnt -= prefixCapacity[ceil-1];
            }
            res[ceil] += Math.min(amnt, prefixCapacity[ceil]);
        }
        long prevcnt = 0;
        for(int i = 0; i<n; i++) {
            prevcnt += cnt[i];
            res[i] += prevcnt*capacity[i];
        }
        
        for(int i = 0; i<n; i++) {
            System.out.print(res[i]+" ");
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