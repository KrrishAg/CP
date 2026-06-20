
import java.io.*;
import java.lang.*;
import java.util.*;

public class CDijkstra {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        // int t = sc.nextInt();
        // while(t-->0) {
            solve();
        // }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<long[]>> g = new ArrayList<>();
        for(int i = 0; i<=n; i++) g.add(new ArrayList<>());
        for(int i = 0; i<m; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long wt = sc.nextLong();
            g.get((int)a).add(new long[]{b,wt});
            g.get((int)b).add(new long[]{a,wt});
        }
        boolean vis[] = new boolean[n+1];
        int parent[] = new int[n+1];
        PriorityQueue<long[]> pq = new PriorityQueue<>((p,q)->(int)(p[1]-q[1]));
        pq.offer(new long[]{1,0,-1});
        while(!pq.isEmpty()) {
            long curr[] = pq.poll();
            int u = (int)curr[0]; long currWt = curr[1]; int par = (int)curr[2];
            if(vis[u]) continue;
            vis[u] = true;
            parent[u] = par;

            if(u==n) break;

            for(long neighbours[] : g.get(u)) {
                int v = (int)neighbours[0]; long adjWt = neighbours[1];
                if(!vis[v]) {
                    pq.offer(new long[]{v,currWt+adjWt,u});
                    // System.out.println(pq.peek()[1]);
                }
            }
        }

        if(parent[n] == 0) System.out.println(-1);
        else {
            ArrayList<Integer> al = new ArrayList<>();
            int curr = n;
            while(curr != -1) {
                al.add(curr);
                curr = parent[curr];
            }
            for(int u:al.reversed()) System.out.print(u+" ");
            System.out.println();
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