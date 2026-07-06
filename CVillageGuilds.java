
import java.io.*;
import java.lang.*;
import java.util.*;

public class CVillageGuilds {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static long res = 0;
    static void solve() throws IOException {
        int n = sc.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i<=n; i++) g.add(new ArrayList<>());
        for(int i = 2; i<=n; i++) {
            int par = sc.nextInt();
            g.get(par).add(i);
        }
        res = n;
        fn1(1,g);
        System.out.println(res);
    }


    static long fn1(int u, List<List<Integer>> g) {
        long sm = 0, m = 0;
        for(int v : g.get(u)) {
            long curr = fn1(v,g);
            if(m==0) m = curr;
            else {
                if(curr>=m) {
                    sm = m;
                    m = curr;
                }
                else if(curr>sm) {
                    sm = curr;
                }
            }
            // if(u==3) System.out.println(u+" "+m+" "+sm);
        }
        res += sm;
        return m+1;
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