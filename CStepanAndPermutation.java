
import java.io.*;
import java.lang.*;
import java.util.*;

public class CStepanAndPermutation {
    
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
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] arr = new int[n];
        input(arr);

        DS ds = new DS(n+1);
        for(int i = 1; i<=n; i++) {
            if(i+x<=n) ds.union(i, i+x);
            if(i+y<=n) ds.union(i, i+y);
        }

        for(int i = 1; i<=n; i++) {
            if(ds.getUPar(i) != ds.getUPar(arr[i-1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static class DS {
        int par[], size[];
        DS(int n) {
            par = new int[n];
            size = new int[n];
            for(int i = 0; i<n; i++) {
                par[i] = i;
                size[i] = 1;
            }
        }
        int getUPar(int u) {
            int p = par[u];
            if(p==u) return p;
            else return getUPar(p);
        }
        void union(int u, int v) {
            int pu = getUPar(u), pv = getUPar(v);
            if(pu==pv) return;
            int su = size[pu], sv = size[pv];
            if(su>=sv) {
                par[pv] = pu;
                size[pu] += sv;
            }
            else {
                par[pu] = pv;
                size[pv] += su;
            }
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