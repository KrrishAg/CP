
import java.io.*;
import java.lang.*;
import java.util.*;

public class DTwoDigitStrings {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        String a = sc.next();    
        String b = sc.next();    
        int m = a.length(), n = b.length();
        int prea[] = new int[m];
        for(int i = 0; i<m; i++) {
            int ch = a.charAt(i)-'0';
            prea[i] = (i==0) ? ch : (prea[i-1]+ch)%10;
        }
        int preb[] = new int[n];
        for(int i = 0; i<n; i++) {
            int ch = b.charAt(i)-'0';
            preb[i] = (i==0) ? ch : (preb[i-1]+ch)%10;
        }
        // if(prea[m-1] != preb[n-1]) {
        //     System.out.println(-1);
        //     return;
        // }
        int dp[][] = new int[m][n];
        for(int x[]: dp) Arrays.fill(x,-1);
        fn(dp,m-1,n-1,prea,preb);
        System.out.println(dp[m-1][n-1]);
    }
    static int fn(int dp[][], int i, int j, int prea[], int preb[]) {
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(prea[i]==preb[j]) {
            int tmp = fn(dp,i-1,j-1,prea,preb);
            dp[i][j] = tmp+1;
        }
        else {
            int tmp = Math.max(fn(dp,i-1,j,prea,preb), fn(dp,i,j-1,prea,preb));
            dp[i][j] = tmp;
        }
        return dp[i][j];
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