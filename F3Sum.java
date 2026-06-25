
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class F3Sum {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        int arr[] = new int[10];
        int n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            int x = sc.nextInt();
            arr[x%10]++;
        }
        for(int i = 0; i<=9; i++) {
            for(int j = 0; j<=9; j++) {
                for(int k = 0; k<=9; k++) {
                    if((i+j+k)%10 == 3) {
                        arr[i]--;
                        arr[j]--;
                        arr[k]--;
                        if(arr[i]>=0 && arr[j]>=0 && arr[k]>=0) {
                            System.out.println("YES");
                            return;
                        }
                        arr[i]++;
                        arr[j]++;
                        arr[k]++;
                    }
                }
            }
        }
        System.out.println("NO");
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