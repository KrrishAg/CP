
import java.io.*;
import java.lang.*;
import java.util.*;

public class CMexor {
    
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
        if(n==1 && k==0) {
            System.out.println("NO");
            return;
        }

        long x = n^k;
        ArrayList<Integer> al = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        int curr = 1;
        while(x>0) {
            if((x&1)==1) {
                al.add(curr);
                hs.add(curr);
                if(curr>=n) {
                    System.out.println("NO");
                    return;
                }
            }
            curr = curr*2;
            x>>=1;
        }
        Collections.sort(al);
        System.out.println("YES");
        for(int i = 1; i<n; i++) {
            if(!hs.contains(i)) System.out.print(i+" ");
        }
        System.out.print(0+" ");
        for(int num:al) {
            System.out.print(num+" ");
        } 
        System.out.println();
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