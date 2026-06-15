
import java.io.*;
import java.lang.*;
import java.util.*;

public class DBrandNewTatarTvShow {
    
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
        int k = sc.nextInt();
        long[] arr = new long[n];
        input(arr);
        Arrays.sort(arr);
        long[] tmp = new long[n];
        int i = n-1;
        long st = arr[i], cnt = 0;
        int j = i;
        while(i>=0 && arr[i]==st) {
            cnt++;
            i--;
        }
        for(int idx = i+1; idx<=j; idx++) {
            tmp[idx] = cnt;
        }
        while(i>=0) {
            if(arr[i+1]-arr[i] <=k) {
                st = arr[i]; long val = tmp[i+1]+1;
                while(i>=0 && arr[i]==st) {
                    tmp[i] = val;
                    val++;
                    i--;
                }
            }
            else {
                st = arr[i];cnt = 0;
                j = i;
                while(i>=0 && arr[i]==st) {
                    cnt++;
                    i--;
                }
                for(int idx = i+1; idx<=j; idx++) {
                    tmp[idx] = cnt;
                }
            }
        }
        for(long x:tmp) {
            if((x&1)==0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
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