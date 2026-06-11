
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class CScheduleManagement {
    
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
        int m = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<m; i++) {
            int x = sc.nextInt()-1;
            arr[x]++;
        }
        Arrays.sort(arr);
        long l = 0, r = (long)1e12, res = -1;
        while(l<=r) {
            long mid = l+(r-l)/2;
            long xtra = 0;
            for(int i = n-1; i>=0; i--) {
                if(arr[i]>=mid) {
                    xtra += arr[i]-mid;
                } 
                else {
                    xtra = Math.max(0, xtra - (mid-arr[i])/2);
                    if(xtra==0) break;
                }
            }
            if(xtra==0) {
                res = mid;
                r = mid-1;
            }
            else l = mid+1;
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