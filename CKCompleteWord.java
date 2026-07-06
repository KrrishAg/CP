
import java.io.*;
import java.lang.*;
import java.util.*;

public class CKCompleteWord {
    
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
        String s = sc.next();
        long res = 0, seg = n/k;
        for(int i = 0; 2*i<k; i++) {
            int l = i, r = k-1-i;
            int cnt[] = new int[26];
            for(int j = l; j<n; j+=k) cnt[s.charAt(j)-'a']++;
            if(l!=r) for(int j = r; j<n; j+=k) cnt[s.charAt(j)-'a']++;
            int m = 0;
            for(int x : cnt) m = Math.max(m,x);
            if(l!=r) res += (2*seg - m);
            else res += (seg - m);
        }
        System.out.println(res);
    }

    //wudixia oxingxi ngheclp


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