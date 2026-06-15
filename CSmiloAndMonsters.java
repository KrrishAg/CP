
import java.io.*;
import java.lang.*;
import java.util.*;

public class CSmiloAndMonsters {
    
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
        long[] arr = new long[n];
        input(arr);
        Arrays.sort(arr);   
        int l = 0, r = n-1;
        long x = 0, res = 0;
        while(l<=r) {
            long rem = arr[r]-x;
            if(l==r) {
                if(rem<=0) res++;
                else {
                    if(rem%2 == 1) {
                        arr[r]--;
                        rem--;
                        res++;
                    }
                    if(arr[r]>0) {
                        res += rem/2;
                        res++;
                    }
                }
                l++;
            } 
            else {
                if(arr[l]<=rem) {
                    res += arr[l];
                    x += arr[l];
                    l++;
                }
                else {
                    res += rem;
                    res++;
                    r--;
                    x=0;
                    arr[l]-=rem;
                }
            }
            // System.out.println(res);
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