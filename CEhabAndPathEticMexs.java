
import java.io.*;
import java.lang.*;
import java.util.*;

public class CEhabAndPathEticMexs {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = 1;
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        List<List<int[]>> al = new ArrayList<>();
        for(int i = 0; i<n+1; i++) al.add(new ArrayList<>());
        for(int i = 0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            al.get(u).add(new int[]{v,i});
            al.get(v).add(new int[]{u,i});
        }
        if(n==2) {
            System.out.println(0);
            return;
        }
        int res[] = new int[n-1], val = 0;
        Arrays.fill(res,-1);
        for(List<int[]> curr : al) {
            if(curr.size() == 1) {
                int idx = curr.get(0)[1];
                res[idx] = val++;
            } 
        }
        for(int i = 0; i<res.length; i++) {
            if(res[i] == -1) res[i] = val++;
        }
        for(int x:res) System.out.println(x);
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