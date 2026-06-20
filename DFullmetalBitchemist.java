
import java.io.*;
import java.lang.*;
import java.util.*;

public class DFullmetalBitchemist {
    
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
        int diff = 0;
        long arr[] = new long[3];
        arr[0] = 1;
        long res = 0;
        for(char ch:s.toCharArray()) {
            if(ch=='0') diff--;
            else diff++;
            
            if(diff==-1) diff = 2;
            else if(diff==3) diff = 0;
            res += arr[(diff+1)%3] + arr[(diff+2)%3];
            arr[diff]++;
        }   
        int i = 0;
        while(i<n) {
            int j = i+1;
            while(j<n && s.charAt(j)!=s.charAt(j-1)) j++;
            long len = j-i;
            long rem = 0;
            if(len%2==0) {
                rem = ((len/2) * (2+len))/2;
            }
            else {
                rem = (((len+1)/2) * (1+len))/2;
            }
            rem -= len;
            res -= rem;

            i = j;
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