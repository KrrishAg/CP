
import java.io.*;
import java.lang.*;
import java.util.*;

public class BTheNumberOfProducts {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            int x = sc.nextInt();
            if(x<0) arr[i] = -1;
            else arr[i] = 1;
        }
        long resN = 0;
        long prev1 = 0, prev2 = 0, currP = 0;
        int i = 0;
        while(i<n) {
            if(arr[i]==1) {
                while(i<n && arr[i]==1) {
                    currP++;
                    long tmpRes = prev1;
                    resN += tmpRes;
                    i++;
                }
            }
            else {
                long tmpRes = currP + 1 + prev2;
                resN += tmpRes;
                prev2 = prev1;
                prev1 = tmpRes;
                currP = 0;
                i++;
            }
        }
        System.out.println(resN + " " + (((long)(n)*(n+1))/2 - resN));
    }

    static void solve() throws IOException {
        
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