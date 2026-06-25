
import java.io.*;
import java.lang.*;
import java.util.*;

public class TreeSwappingEasy {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 998244353;
    
    static long[] f = new long[5005];
    static long[] inv = new long[5005];
    
    static {
        f[0] = 1;
        inv[0] = 1;
        for (int i = 1; i < 5005; i++) {
            f[i] = (f[i - 1] * i) % MOD;
        }
        inv[5004] = bp(f[5004], MOD - 2);
        for (int i = 5003; i >= 0; i--) {
            inv[i] = (inv[i + 1] * (i + 1)) % MOD;
        }
    }
    
    static long bp(long b, long e) {
        long r = 1;
        b %= MOD;
        while (e > 0) {
            if (e % 2 == 1) r = (r * b) % MOD;
            b = (b * b) % MOD;
            e /= 2;
        }
        return r;
    }
    
    static long ncr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return f[n] * inv[r] % MOD * inv[n - r] % MOD;
    }

    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static ArrayList<ArrayList<Integer>> g;
    static int[] a, b, c;
    static String s, z;

    static void solve() throws IOException {
        int n = sc.nextInt();
        g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.get(u).add(v);
            g.get(v).add(u);
        }
        s = sc.next();
        z = sc.next();
        
        int x = 0;
        for (int i = 0; i < n; i++) if (z.charAt(i) == '1') x++;
        
        int y = 0, w = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') y++;
            if (s.charAt(i) == '?') w++;
        }
        
        int k = x - y;
        if (k < 0 || k > w) {
            System.out.println(0);
            return;
        }
        
        a = new int[n + 1];
        b = new int[n + 1];
        c = new int[n + 1];
        
        dfs(1, 0);
        
        long r = 0;
        for (int i = 2; i <= n; i++) {
            int n1 = a[i];
            int q1 = b[i];
            int t1 = c[i];
            int q2 = w - q1;
            
            long o = 0;
            int m1 = Math.max(0, k - q2);
            int m2 = Math.min(q1, k);
            
            for (int j = m1; j <= m2; j++) {
                long v1 = ncr(q1, j) * ncr(q2, k - j) % MOD;
                long v2 = Math.abs(n1 + j - t1);
                o = (o + (v1 * v2) % MOD) % MOD;
            }
            r = (r + o) % MOD;
        }
        System.out.println(r);
    }
    
    static void dfs(int u, int p) {
        a[u] = (s.charAt(u - 1) == '1' ? 1 : 0);
        b[u] = (s.charAt(u - 1) == '?' ? 1 : 0);
        c[u] = (z.charAt(u - 1) == '1' ? 1 : 0);
        for (int v : g.get(u)) {
            if (v != p) {
                dfs(v, u);
                a[u] += a[v];
                b[u] += b[v];
                c[u] += c[v];
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
