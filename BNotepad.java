
import java.io.*;
import java.lang.*;
import java.util.*;

public class BNotepad {
    
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
        if(n<=3) {
            System.out.println("NO");
            return;
        }
        HashSet<Integer> hs = new HashSet<>();
        // hs.add((s.charAt(0)-'a'+1)*31 + (s.charAt(1)-'a'+1));
        int prev = (s.charAt(0)-'a'+1)*31 + (s.charAt(1)-'a'+1);
        for(int i = 1; i<n-1; i++) {
            int curr = (s.charAt(i)-'a'+1)*31 + (s.charAt(i+1)-'a'+1);
            if(hs.contains(curr)) {
                System.out.println("YES");
                return;
            }
            hs.add(prev);
            prev = curr;
        }
        System.out.println("NO");
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