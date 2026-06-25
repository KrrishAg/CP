
import java.io.*;
import java.lang.*;
import java.util.*;

public class CFactorialsAndPowersOfTwo {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    static long f[] = new long[16];
    static long sq[] = new long[41];
    static HashMap<Long,List<Long>> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        f[0] = 1; sq[0] = 1;
        for(int i = 1; i<f.length; i++) f[i] = i*f[i-1];
        for(int i = 1; i<sq.length; i++) sq[i] = 2*sq[i-1];
        for(long x : f) {
            long xx = x;
            List<Long> tmp = new ArrayList<>();
            for(int i = sq.length-1; i>=0; i--) {
                if(sq[i]<=x) {
                    x-=sq[i];
                    tmp.add(sq[i]);
                }
            }    
            hm.put(xx,tmp);
        }

        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        long n = sc.nextLong();
        ArrayList<Long> al = new ArrayList<>();
        HashSet<Long> hs = new HashSet<>();
        for(long x:hs) al.add(x);
        // Collections.sort(al);
        // System.out.println(al);
        long res = 0, rem= n, sum = 0;
        for(int i = sq.length-1; i>=0; i--) {
            if(sq[i]<=rem) {
                rem-=sq[i];
                // al.add(sq[i]);
                // hs.add(sq[i]);
                res++;
            }
        }
        // System.out.println(res);
        res = Math.min(res, fn(n,f.length-1));

        if(rem>0) System.out.println(-1);
        else System.out.println(res);
    }

    static int fn(long n, int i) {
        if(i==-1) {
            int tmp = 0;
            for(int idx = sq.length-1; idx>=0; idx--) {
                // System.out.println(sq[idx]+" "+n);
                if(sq[idx]<=n) {
                    n-=sq[idx];
                    tmp++;
                }
            }
            // System.out.println(tmp+"=="+n);
            return tmp;
        }
        int tmpres = fn(n,i-1);
        if(f[i]<=n) tmpres = Math.min(tmpres, 1 + fn(n-f[i], i-1));
        return tmpres;
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