
import java.io.*;
import java.lang.*;
import java.util.*;

public class CQueen {
    
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
        List<List<Integer>> al = new ArrayList<>();
        boolean[] respect = new boolean[n+1];
        for(int i = 0; i<=n; i++) al.add(new ArrayList<>());
        int root = -1;
        boolean res[] = new boolean[n+1];
        for(int i = 1; i<=n; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            if(p!=-1) al.get(p).add(i);
            else root = i;
            respect[i] = c==0; 
        }
        // dfs(root,al,respect,res);
        for(int i = 1; i<=n; i++) {
            boolean bad = !respect[i];
            for(int v:al.get(i)) {
                bad = bad & !respect[v];
            }
            if(bad) res[i] = true;
            else res[i] = false;
        }

        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            if(res[i]) tmp.add(i);
        }
        Collections.sort(tmp);
        if(tmp.isEmpty()) System.out.println(-1);
        else {
            for(int x:tmp) System.out.print(x+" ");
            System.out.println();
        }
    }

    static boolean dfs(int u, List<List<Integer>> al, boolean respect[], boolean res[]) {
        boolean bad = true;
        for(int v:al.get(u)) {
            bad &= dfs(v,al,respect,res);
        }
        if(bad & !respect[u]) res[u] = true;
        else res[u] = false;
        return bad & !respect[u];
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