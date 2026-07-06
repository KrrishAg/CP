
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class AAnotherPuzzleFromPapyrus {
    
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
        int cost = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        input(a);
        input(b);

        boolean corr = true;
        for(int i = 0; i<n; i++) {
            if(a[i]<b[i]) corr = false;
        }
        if(corr) {
            int res1 = 0, res2 = 0;
            for(int i = 0; i<n; i++) {
                res1 += a[i]-b[i];
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for(int i = 0; i<n; i++) {
                res2 += a[i]-b[i];
            }
            System.out.println(Math.min(res1,res2+cost));
        }
        else {
            Arrays.sort(a);
            Arrays.sort(b);
            corr = true;
            int res = 0;
            for(int i = 0; i<n; i++) {
                if(a[i]<b[i]) {
                    corr = false;
                    break;
                }
                else res += a[i]-b[i];
            }
            if(!corr) System.out.println(-1);
            else System.out.println(res+cost);

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