
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class EAnnaAndTheValentineSDayGift {
    
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
        int m = sc.nextInt();        
        int[][] arr = new int[n][3];
        int totd = 0;
        for(int i = 0; i<n; i++) {
            int x = sc.nextInt();
            arr[i][0] = x;
            int z = 0, tot = 0; boolean prevZ = true;
            while(x>0) {
                int d = x%10;
                tot++;
                if(prevZ && d==0) z++;
                if(d!=0) prevZ= false;
                x/=10;
            }
            arr[i][1] = tot;
            arr[i][2] = z;
            totd += tot;
        }
        Arrays.sort(arr, (p,q)->q[2]-p[2]);
        // for(int x[]:arr) System.out.println(Arrays.toString(x));
        int anna = 0;
        for(int i = 0; i<n; i+=2) {
            anna += arr[i][2];
        }
        if(totd-anna >=m+1) System.out.println("Sasha");
        else System.out.println("Anna");
        // System.out.println("+=");
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