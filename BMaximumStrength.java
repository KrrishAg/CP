
import java.io.*;
import java.lang.*;
import java.util.*;

public class BMaximumStrength {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        String a = sc.next();
        String b = sc.next();
        int la = a.length(), lb = b.length();
        long res = 0;
        if(la != lb) {
            int diffcnt = 0;
            for(int i = 1; i<lb-la; i++) {
                if(b.charAt(i)!='9') diffcnt++;
                res+=9;
            }
            if(diffcnt==0) res+=b.charAt(0)-'0';
            else res+=b.charAt(0)-'0'-1;
            res += Math.min(la,lb)*9;
        }
        else {
            int i = 0;
            for(; i<la; i++) {
                if(a.charAt(i)==b.charAt(i)) continue;
                else {
                    res += Math.abs(a.charAt(i)-b.charAt(i)); 
                    break;
                }
            }
            if(i<la) res += (la-i-1)*9;
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