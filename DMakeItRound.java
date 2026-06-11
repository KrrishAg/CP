
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class DMakeItRound {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        long n = sc.nextLong(), nn = n;
        long m = sc.nextLong();
        int t =0, f = 0;
        while(n>0 && n%2==0) {
            n/=2;
            t++;
        } 
        while(n>0 && n%5==0) {
            n/=5;
            f++;
        } 
        if(t<=f) {
            f-=t;
            t=0;
        }
        else {
            t-=f;
            f=0;
        }


        long tmp = 1;
        if(t>0) {
            while(t>0 && tmp*5<=m) {
                tmp*=5;
                t--;
            }
        }
        else {
            while(f>0 && tmp*2<=m) {
                tmp*=2;
                f--;
            }
        }
        while(tmp*10<=m) tmp*=10;
        tmp *= (m/tmp); 
        System.out.println(nn*tmp);
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