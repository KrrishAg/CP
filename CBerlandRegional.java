
import java.io.*;
import java.lang.*;
import java.util.*;

public class CBerlandRegional {
    
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
        int[] arr1 = new int[n];
        long[] arr2 = new long[n];
        input(arr1);
        input(arr2);

        HashMap<Integer,List<Long>> hm = new HashMap<>();    
        for(int i = 0; i<n; i++) {
            if(!hm.containsKey(arr1[i])) hm.put(arr1[i], new ArrayList<>());   
            hm.get(arr1[i]).add(arr2[i]);
        }
        for(List<Long> al:hm.values()) {
            Collections.sort(al);
            for(int i = 1; i<al.size(); i++) {
                al.set(i, al.get(i)+al.get(i-1));
            }
        }
        long res[] = new long[n];
        for(List<Long> al:hm.values()) {
            // System.out.println(al);
            for(int k = 1; k<=al.size(); k++) {
                int rem = al.size() % k;
                if(rem==0) {
                    res[k-1] += al.getLast();
                }
                else {
                    res[k-1] += al.getLast() - al.get(rem-1);
                }
            }
        }
        for(long x: res) System.out.print(x+" ");
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