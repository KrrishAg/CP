
import java.io.*;
import java.lang.*;
import java.util.*;

public class CMortalKombatTower {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    // dp[i][j][k]  ->  cost of using jth person from i to n-1 if jth person has already killed k mosters 
    static void solve() throws IOException {
        int n = sc.nextInt();
        int[] arr = new int[n];
        input(arr);
        int dp[][][] = new int[n][2][3];
        //0 -> friend

        if(arr[n-1] == 1) {
            dp[n-1][0][1] = 1;
            dp[n-1][0][2] = 1;
        }
        for(int i = n-2; i>=0; i--) {
            dp[i][0][1] = Math.min(dp[i+1][1][1], dp[i+1][1][2]); 
            dp[i][0][2] = dp[i+1][0][1];
            dp[i][1][1] = Math.min(dp[i+1][0][1], dp[i+1][0][2]); 
            dp[i][1][2] = dp[i+1][1][1];
            if(arr[i]==1) {
                dp[i][0][1]++;
                dp[i][0][2]++;
            }
        }
        int res = Math.min(dp[0][0][1],dp[0][0][2]);
        System.out.println(res);
    }

    // static void solve() throws IOException {
    //     int n = sc.nextInt();
    //     int[] arr = new int[n];
    //     input(arr);
    //     int dp[][] = new int[n][2];
    //     //0 -> friend
    //     dp[n-1][0] = arr[n-1]==1 ? 1 : 0;
    //     for(int i = n-2; i>=0; i--) {
    //         dp[i][0] = Math.min(dp[i+1][0], dp[i+1][1]);
    //         dp[i][1] = Math.min(dp[i+1][0], dp[i+1][1]);
    //         if(i+2<n) {
    //             dp[i][0] = Math.min(dp[i][0], dp[i+2][1]);
    //             dp[i][1] = Math.min(dp[i][1], dp[i+2][0]);
    //         }
    //         if(arr[i] == 1) dp[i][0]++;
    //     }
    //     for(int i = 0; i<n; i++) {
    //         System.out.print(dp[i][0]+" ");
    //     }
    //     System.out.println();
    //     for(int i = 0; i<n; i++) {
    //         System.out.print(dp[i][1]+" ");
    //     }
    //     System.out.println();
    //     int res = Math.min(dp[0][0],dp[0][1]);
    //     System.out.println(res);
    // }


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