
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class DividingBy2 {
    
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
        int[] arr = new int[n];
        input(arr);
        HashMap<Integer,Integer> cnt = new HashMap<>();
        HashMap<Integer,Integer> moves = new HashMap<>();
        for(int i = 0; i<n; i++) {
            int x = arr[i];
            int tmp = 0;
            while(x>0) {
                cnt.put(x,cnt.getOrDefault(x,0)+1);
                moves.put(x,moves.getOrDefault(x,0)+tmp);
                tmp++;
                x/=2;
            }
        }
        int res= Integer.MAX_VALUE;
        for(int key:cnt.keySet()) {
            if(cnt.get(key)==n) {
                res = Math.min(res,moves.get(key));
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