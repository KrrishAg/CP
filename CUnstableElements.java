
import java.io.*;
import java.lang.*;
import java.util.*;

public class CUnstableElements {
    
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
        int k = sc.nextInt();
        int arr[] = new int[n];
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i<n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
            hm.put(x, hm.getOrDefault(x,0)+1);
        }
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int v : hm.values()) {
            freq.put(v, freq.getOrDefault(v,0)+1);
        }
        int tmp[][] = new int[freq.size()][2];
        int idx = 0;
        for(int key : freq.keySet()) {
            tmp[idx++] = new int[]{key, freq.get(key)};
        }
        Arrays.sort(tmp, (p,q)->p[0]-q[0]);
        int curr = n, diff = hm.size();
        int res = 0;
        int reduced = 0;
        for(int i = 0; i<tmp.length; i++) {
            tmp[i][0] -= reduced;
            curr -= (tmp[i][0]-1) * diff;
            // System.out.println(curr+" "+diff);
            if(k>=curr && (k-curr)%diff == 0) res++;

            curr -= diff;
            diff -= tmp[i][1];
            reduced += tmp[i][0];
            // System.out.println(res);
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