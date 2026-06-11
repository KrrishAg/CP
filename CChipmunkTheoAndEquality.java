
import java.io.*;
import java.lang.*;
import java.util.*;

public class CChipmunkTheoAndEquality {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
        System.out.println(sb);
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int[] arr = new int[n];
        input(arr);
        HashMap<Integer,Integer> count = new HashMap<>();
        HashMap<Integer,Integer> turns = new HashMap<>();
        
        fill(turns,arr[0],count,false);
        
        for(int i = 1; i<n; i++) {
            fill(turns,arr[i],count,true);
        }
        // System.out.println(count);
        int res = Integer.MAX_VALUE;
        for(int k : count.keySet()) {
            if(count.get(k) == n) {
                res = Math.min(res, turns.get(k));
            }
        }
        System.out.println(res);
    }
    
    static void fill(HashMap<Integer,Integer> turns, int x, HashMap<Integer,Integer> count, boolean check) {
        int cnt = 0;
        while(x>=1) {
            boolean cond = !check || (check && count.containsKey(x));

            if(x==1 || x==2) {
                if(x==1) {
                    if(cond) {
                        turns.put(1, turns.getOrDefault(1,0)+cnt);
                        turns.put(2, turns.getOrDefault(2,0)+cnt+1);
                    }
                }
                else if(x==2) {
                    if(cond) {
                        turns.put(2, turns.getOrDefault(2,0)+cnt);
                        turns.put(1, turns.getOrDefault(1,0)+cnt+1);
                    }
                }
                if(cond) {
                    count.put(1, count.getOrDefault(1,0)+1);
                    count.put(2, count.getOrDefault(2,0)+1);
                }
                break;
            }
            else {
                if(cond) {
                    turns.put(x, turns.getOrDefault(x,0)+cnt);
                    count.put(x, count.getOrDefault(x,0)+1);
                }
                x = nxt(x);
                cnt++;
            }
        }    
    }

    static int nxt(int x) {
        if((x&1)==0) return x/2;
        else return x+1;
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