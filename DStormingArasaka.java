
import java.io.*;
import java.lang.*;
import java.util.*;

public class DStormingArasaka {
    
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
        ArrayList<Integer> fact = new ArrayList<>();
        for(int i = 2; i*i<=n; i++) {
            if(n%i == 0) {
                fact.add(i);
                if(i!=n/i) fact.add(n/i);
            }
        }
        fact.add(n);
        Collections.sort(fact);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0; i<fact.size(); i++) {
            int x = fact.get(i);
            if(!hm.containsKey(x)) hm.put(x,1);
            int curr = hm.get(x);
            
            for(int j = i+1; j<fact.size(); j++) {
                int y = fact.get(j);
                if(y % x == 0) {
                    if(!hm.containsKey(y)) hm.put(y,curr+1);
                    else hm.put(y,Math.max(hm.get(y),curr+1));
                }
            }
        }

        int M = 0, cnt = 0;
        for(int v:hm.values()) {
            M = Math.max(M,v);
            if(v==1) cnt++;
        }
        int res = M+cnt-1;
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