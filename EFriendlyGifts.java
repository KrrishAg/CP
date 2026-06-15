
import java.io.*;
import java.lang.*;
import java.util.*;

public class EFriendlyGifts {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
        System.out.println(sb);
    }

    static class Pair{
       int m, M;
       Pair(int m, int M) {this.m=m;this.M=M;}
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int[] arr = new int[n];
        input(arr);

        boolean dp[][] = new boolean[n+1][n+1];
        for(int i = 0; i<n; i++) {
            HashSet<Integer> hs = new HashSet<>();
            int m = Integer.MAX_VALUE, M = Integer.MIN_VALUE;
            for(int j = i; j<n; j++) {
                m = Math.min(m,arr[j]);
                M = Math.max(M,arr[j]);
                hs.add(arr[j]);
                int len = j-i+1;
                if(hs.size()==len && M-m+1==len) {
                    dp[m][M] = true;
                }
            }
        }

        for(int len = n/2; len>0; len--) {
            for(int i = 1; i+2*len-1<=n; i++) {
                if(dp[i][i+len-1] && dp[i+len][i+2*len-1]) {
                    sb.append(len+"\n");
                    return;
                }
            }
            
        }
        sb.append(0+"\n");

        // ArrayList<int[]> al = new ArrayList<>();
        // int l = 1, r = n/2, res = 0;
        // while(l<=r) {
        //     int mid = l+(r-l)/2;
        //     boolean found = false;
        //     for(int i = 0; i<n && i+mid-1<n; i++) {
        //         if(dp[i][i+mid-1]) {
        //             for(int j = i+mid; j<n && j+mid-1<n; j++) {
        //                 if(dp[j][j+mid-1]) {
        //                     //found subseg from i & j

        //                     HashSet<Integer> hs = new HashSet<>();
        //                     int m = Integer.MAX_VALUE, M = Integer.MIN_VALUE;
        //                     //doing for i
        //                 }
        //             }
        //         }
        //         if(found) break;
        //     }
        //     if(found) {
        //         res = mid;
        //         l = mid+1;
        //     }
        //     else r = mid-1;
        // }
        // System.out.println(res);
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