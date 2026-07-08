
import java.io.*;
import java.lang.*;
import java.util.*;

public class BPredominantFrequencyDivision {
    
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
        int arr[] = new int[n];
        for(int i = 0; i<n; i++) arr[i] = sc.nextInt();

        int curr = 1, sm = 0, tot = 0;
        int i = 0;
        while(i<n) {
            if(curr==1) {
                if(arr[i]==1) sm++;
                tot++;
                if(2*sm>=tot) {
                    if(i+1<n && 2*sm>tot && arr[i+1]==3) {
                        i++;
                        continue;
                    }
                    else {
                        curr++;
                        sm = 0;
                        tot = 0;
                    }
                }
            }
            else if(curr==2) {
                if(arr[i]<=2) sm++;
                tot++;
                if(2*sm>=tot) {
                    curr++;
                    sm = 0;
                    tot = 0;
                }
            }
            else {
                curr++;
                i = n;
            }
            i++;
        }
        if(curr==4) System.out.println("YES");
        else System.out.println("NO");
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