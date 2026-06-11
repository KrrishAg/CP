
import java.io.*;
import java.lang.*;
import java.util.*;

public class ACopilCopacDrawsTrees {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static class Pair {
        int num, idx;
        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        List<List<Pair>> al = new ArrayList<>();
        for(int i = 0; i<=n; i++) {
            al.add(new ArrayList<>());
        }
        for(int i = 0; i<n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            al.get(a).add(new Pair(b,i));
            al.get(b).add(new Pair(a,i));
        }
        
        int dp[] = new int[n+1];
        int activateIdx[] = new int[n+1];
        dp[1] = 1;
        activateIdx[1] = 0;
        dfs(1,-1,al,dp,activateIdx);
        int res = 0;
        for(int i :dp) res = Math.max(res,i);
        System.out.println(res);
    }

    static void dfs(int u, int par, List<List<Pair>> al, int dp[], int activateIdx[]) {
        // System.out.println(u);
        for(Pair p:al.get(u)) {
            int v = p.num, idx = p.idx;
            if(v==par) continue;
            if(idx<activateIdx[u]) {
                dp[v] = dp[u]+1;
            }
            else {
                dp[v] = dp[u];
            }
            activateIdx[v] = idx;
            dfs(v, u, al, dp, activateIdx);
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