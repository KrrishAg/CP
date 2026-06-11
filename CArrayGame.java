
import java.io.*;
import java.lang.*;
import java.util.*;

public class CArrayGame {
    
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
        int k = sc.nextInt();
        ArrayList<Long> al = new ArrayList<>();
        long m = Long.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            long x = sc.nextLong();
            al.add(x);
            m = Math.min(m,x);
        }
        if(k>=3) {
            System.out.println(0);
            return;
        }
        if(k==0) {
            System.out.println(m);
            return;
        }
        Collections.sort(al);
        for(int i = 0; i<n-1; i++) {  
            long tmp = al.get(i+1)-al.get(i);
            m = Math.min(m,tmp);
        }
        if(k==1) {
            System.out.println(m);
            return;
        }
        else {
            if(m==0) {
                System.out.println(m);
                return;
            }
            for(int i = 0; i<n; i++) { 
                for(int j = 0; j<n; j++) {
                    if(i==j) continue;
                    long tmp = Math.abs(al.get(i)-al.get(j));
                    long c = -1;
                    int l = 0, r = n-1;
                    while(l<=r) {
                        int mid = l+(r-l)/2;
                        if(al.get(mid)<tmp) l = mid+1;
                        else {
                            c = al.get(mid);
                            r = mid-1;
                        }
                    }
                    long f = -1;
                    l = 0; r = n-1;
                    while(l<=r) {
                        int mid = l+(r-l)/2;
                        if(al.get(mid)>tmp) r = mid-1;
                        else {
                            f = al.get(mid);
                            l = mid+1;
                        }
                    }
                    if(c!=-1) m = Math.min(m, c-tmp);
                    if(f!=-1) m = Math.min(m, tmp-f);
                    
                } 
            }   
            System.out.println(m);
        }
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