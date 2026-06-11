
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class DZeroRemainderArray {
    
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
        long k = sc.nextLong();
        long[] arr = new long[n];
        HashMap<Long,Long> hm = new HashMap<>();
        long MRemFreq = 0, MNum = 0;
        for(int i = 0; i<n; i++) {
            long x = sc.nextLong();
            arr[i] = x;
            long key = (k-(x%k))%k;
            if(key==0) continue;
            hm.put(key, hm.getOrDefault(key,0L)+1);
            long val = hm.get(key);
            if(val>MRemFreq) {
                MRemFreq = val;
                MNum = key;
            }
            else if(val==MRemFreq) {
                MNum = Math.max(MNum,key);
            }
        }
        if(MRemFreq==0) System.out.println(0);
        else System.out.println((MRemFreq-1)*k + MNum + 1);
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