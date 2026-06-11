
import java.io.*;
import java.lang.*;
import java.util.*;

public class DBracketColoring {
    
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
        String s = sc.next();
        int tmp[] = new int[n];
        int curr = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i<n; i++) {
            if(s.charAt(i)=='(') curr++;
            else curr--;

            if(curr>0) {
                tmp[i] = 1;
                hs.add(1);
            }
            else if(curr<0) {
                tmp[i] = 2;
                hs.add(2);
            }
            else tmp[i] = tmp[i-1];
        }
        if(curr!=0) System.out.println(-1);
        else {
            System.out.println(hs.size());
            if(hs.size()==1) {
                for(int i:tmp) System.out.print(1+" ");
            }
            else {
                for(int i:tmp) System.out.print(i+" ");
            }
            System.out.println();
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