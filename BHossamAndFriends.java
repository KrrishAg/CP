
import java.io.*;
import java.lang.*;
import java.util.*;

public class BHossamAndFriends {
    
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
        int m = sc.nextInt();    
        HashMap<Integer,TreeSet<Integer>> hm = new HashMap<>();
        for(int i = 0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(!hm.containsKey(Math.max(a,b))) hm.put(Math.max(a,b), new TreeSet<>());
            hm.get(Math.max(a,b)).add(Math.min(a,b));
        }
        long res = 0;
        int s = 1;
        for(int e = 1; e<=n; e++) {
            if(!hm.containsKey(e)) res += (e-s+1);
            else {
                Integer tmp = hm.get(e).floor(e);
                if(tmp>=s) s = tmp+1;
                res += (e-s+1);
            }
        }
        System.out.println(res);
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