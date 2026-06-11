
import java.io.*;
import java.lang.*;
import java.util.*;

public class BOracAndModels {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    static int N = 100004;
    static int seive[] = new int[N];
    
    public static void main(String[] args) throws IOException {
        for(int i = 0; i<N; i++) seive[i] = i;
        for(int i = 2; i*i<N; i++) {
            if(seive[i] == i) {
                for(int j = i*i; j<N; j+=i) {
                    if(seive[j]==j) seive[j] = i;
                }
            }
        }

        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        long[] arr = new long[n+1];
        long[] tmp = new long[n+1];
        for(int i = 1; i<=n; i++) arr[i] = sc.nextLong();
        long res = 0;
        for(int i = 1; i<=n; i++) {
            long tmpRes = 1; int curr = i;
            for(int j = 1; j*j<=i; j++) {
                if(i%j == 0) {
                    int a = j, b = i/j;
                    if(arr[a]<arr[i]) tmpRes = Math.max(tmpRes,tmp[a]+1);
                    if(arr[b]<arr[i]) tmpRes = Math.max(tmpRes,tmp[b]+1);
                }
            }
            tmp[i] = tmpRes;
            res = Math.max(res,tmpRes);
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