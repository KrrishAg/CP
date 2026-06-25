
import java.io.*;
import java.lang.*;
import java.util.*;

public class D13ThLabourOfHeracles {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        gp(4,0,"");
        // while(t-->0) {
        //     solve();
        // }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        // long[] wt = new long[n];
        long graph[][] = new long[n+1][2];
        long sum = 0;
        for(int i = 1; i<=n; i++) {
            long wt = sc.nextLong();
            graph[i][0] = wt;
            sum += wt;
        }
        for(int i = 0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][1]++;
            graph[v][1]++;
        }
        Arrays.sort(graph, (p,q)->(int)(q[0]-p[0]));

        StringBuilder res = new StringBuilder();
        res.append(sum+" ");
        int idx = 0;
        while(graph[idx][1]==1) idx++;
        
        for(int i = 0; i<n-2; i++) {
            sum += graph[idx][0];
            res.append(sum+" ");
            graph[idx][1]--;
            if(graph[idx][1] == 1) {
                while(graph[idx][1]==1) idx++;
            }
        }
        System.out.println(res);
    }

    static void gp(int remopen, int toclose, String s) {
        if(remopen==0 && toclose==0) {
            System.out.println(s);
            return;
        }
        if(remopen>0) {
            gp(remopen-1,toclose+1,s+"(");
        }
        if(toclose>0) {
            gp(remopen,toclose-1,s+")");
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