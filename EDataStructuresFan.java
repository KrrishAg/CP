
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class EDataStructuresFan {
    
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
        String s = sc.next();
        int z = 0, o = 0;
        int tmp[] = new int[n];
        for(int i = 0; i<n; i++) {
            if(i==0) tmp[i] = arr[i];
            else tmp[i] = tmp[i-1]^arr[i];
            if(s.charAt(i)=='0') z^=arr[i];
            else o^=arr[i];
        }

        int q = sc.nextInt();
        for(int i = 0; i<q; i++) {
            int type = sc.nextInt();
            if(type == 1) {
                int l = sc.nextInt()-1;
                int r = sc.nextInt()-1;
                int change = l==0 ? tmp[r] : tmp[r]^tmp[l-1];
                z ^= change;
                o ^= change;
            }
            else {
                if(sc.nextInt() == 0) System.out.print(z+" ");
                else System.out.print(o+" ");
            }
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