
import java.io.*;
import java.lang.*;
import java.util.*;

public class DXorExpressionAndTwoBinaryNumbers {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        long n = sc.nextLong();
        long k = sc.nextLong();
        long a,b,c;
        long tmp = (long)(Math.pow(2,k)+1);
        if(tmp%3==0) {
            a = b = c = tmp/3;
        }
        else {
            a = b = c = tmp/3;
            a++;b++;
        }
        String p = sc.next();
        String q = sc.next();
        StringBuilder mm = new StringBuilder();
        for(int i = 0; i<n; i++) {
            if(p.charAt(i)==q.charAt(i)) mm.append(0);
            else mm.append(1);
        }
        long r1 = cnt(p);
        long r2 = cnt(mm.toString());
        long r3 = cnt(q);
        // System.out.println(a+" "+c+" "+b);
        // System.out.println(r1+" "+r2+" "+r3);
        System.out.println(r1*a + r2*c + r3*b);
    }

    static long cnt(String s) {
        long o = 0, z = 0;
        for(char ch:s.toCharArray()) {
            if(ch=='0') z++;
            else o++;
        }
        return o*z;
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