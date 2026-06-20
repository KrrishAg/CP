
import java.io.*;
import java.lang.*;
import java.util.*;

public class LControllers {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        // int t = sc.nextInt();
        // while(t-->0) {
        //     solve();
        // }
        solve();
    }

    static void solve() throws IOException {
        int len = sc.nextInt();
        String s = sc.next();
        long p = 0, n = 0;
        for(char ch:s.toCharArray()) {
            if(ch=='+') p++;
            else n++;
        }
        int q = sc.nextInt();
        for(int i = 0; i<q; i++) {
            long a = sc.nextLong();    
            long b = sc.nextLong();    

            if(a==b) {
                if(p==n) System.out.println("YES");
                else System.out.println("NO");
                continue;
            }

            boolean poss = check(p,n,a,b);
            if(poss) System.out.println("YES");
            else System.out.println("NO");   
        }
    }

    static boolean check(long p, long n, long a, long b) {
        if(b*(p-n) % (a-b) != 0) {
            return false;
        }

        long e = (b*(p-n))/(a-b);
        if(e>0) {
            if(e<=n) return true;
            else return false;
        }
        else {
            if(-e<=p) return true;
            else return false;
        }
    }

    static long[] gcd(long a, long b) {
        if(a==0) return new long[]{b,0,1};
        long res[] = gcd(b%a,a);
        long g = res[0], x1 = res[1], y1 = res[2];
        long y = x1, x = y1-(b/a)*x1;
        return new long[]{g,x,y};
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