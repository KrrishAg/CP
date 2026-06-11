
import java.io.*;
import java.lang.*;
import java.util.*;

public class CCostOfABracketSequence {
    
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
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<k; i++) {
            int l = 0;
            while(l<n && (s.charAt(l)==')' || hs.contains(l))) l++;
            int r = n-1;
            while(r>=0 && (s.charAt(r)=='(' || hs.contains(r))) r--;

            int c1 = 0;
            for(int j = l+1; j<n; j++) {
                if(s.charAt(j)==')' && !hs.contains(j)) c1++;
            }
            int c2 = 0;
            for(int j = r-1; j>=0; j--) {
                if(s.charAt(j)=='(' && !hs.contains(j)) c2++;
            }

            if(c1>=c2) {
                hs.add(l);
            }
            else {
                hs.add(r);
            }
            // System.out.println(l+" "+r+" "+c1+" "+c2);
        }
        for(int i = 0; i<n; i++) {
            if(hs.contains(i)) System.out.print(1);
            else System.out.print(0);
        }
        System.out.println();
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