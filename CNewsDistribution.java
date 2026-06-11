
import java.io.*;
import java.lang.*;
import java.util.*;

public class CNewsDistribution {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        solve();
    }

    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        DisjointSet(int n) {
            for(int i = 0; i<=n; i++) {
                parent.add(i);
                size.add(1);
            }
        }
        int findUPar(int node) {
            if(parent.get(node)==node) return node;
            int p = findUPar(parent.get(node));
            parent.set(node,p);
            return p;
        }
        void union(int u, int v) {
            int pu = findUPar(u), pv = findUPar(v);
            if(pu==pv) return;
            int su = size.get(pu), sv = size.get(pv);
            if(su>=sv) {
                parent.set(pv,pu);
                size.set(pu,su+sv);
            }
            else {
                parent.set(pu,pv);
                size.set(pv,su+sv);
            }
        }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        DisjointSet ds = new DisjointSet(n);
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i<=n; i++) al.add(new ArrayList<>());
        for(int i = 0; i<m; i++) {
            int k = sc.nextInt();
            if(k==0) continue;
            else if(k==1) {
                int x = sc.nextInt();
            }
            else {
                int prev = sc.nextInt();
                for(int j = 0; j<k-1; j++) {
                    int x = sc.nextInt();
                    ds.union(x, prev);
                    prev = x;
                }
            }
        }
        
        int res[] = new int[n+1];
        for(int i = 1; i<=n; i++) 
            System.out.print(ds.size.get(ds.findUPar(i))+" ");
        System.out.println();
    }

    static int cnt = 0;

    static void count(int u, int parent, ArrayList<ArrayList<Integer>> al, boolean vis[]) {
        vis[u] = true;
        cnt++;
        for(int v:al.get(u)) {
            if(!vis[v]) count(v,u,al,vis);
        }
    }
    static void dfs(int u, int parent, ArrayList<ArrayList<Integer>> al, boolean vis[],int res[]) {
        vis[u] = true;
        res[u] = cnt;
        for(int v:al.get(u)) {
            if(!vis[v]) dfs(v,u,al,vis,res);
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