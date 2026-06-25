
import java.io.*;
import java.lang.*;
import java.util.*;

public class AKAmazingNumbers {
    
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
        int[] arr = new int[n+1];
        int lastOcc[] = new int[n+1];
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        for(int i = 1; i<=n; i++) {
            int x = sc.nextInt();
            if(!hm.containsKey(x)) hm.put(x, new ArrayList<>());
            hm.get(x).add(i-lastOcc[x]);
            lastOcc[x] = i;
        }
        for(int i = 1; i<=n; i++) {
            if(lastOcc[i] != 0) {
                hm.get(i).add(n+1-lastOcc[i]);
            }
        }
        int res[] = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        for(Map.Entry<Integer,List<Integer>> e : hm.entrySet()) {
            int key = e.getKey();
            List<Integer> al = e.getValue();
            if(al.size() == 0) continue;
            int max = 0;
            for(int x : al) max = Math.max(max,x);
            res[max] = Math.min(res[max], key);
        }

        int minAns = Integer.MAX_VALUE;
        int answer[] = new int[n+1];
        for(int i = 1; i<=n; i++) {
            minAns = Math.min(minAns, res[i]);
            if(minAns != Integer.MAX_VALUE) 
                answer[i] = minAns;
            else 
                answer[i] = -1; 
        }
        
        for(int i = 1; i<=n; i++) System.out.print(answer[i]+" ");
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