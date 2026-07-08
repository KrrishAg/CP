
import java.io.*;
import java.lang.*;
import java.util.*;

public class CSymmetricalPolygons {
    
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
        int[] arr = new int[n];
        HashMap<Long,Long> hm = new HashMap<>();
        for(int i = 0; i<n; i++) {
            long x = sc.nextLong();
            hm.put(x,hm.getOrDefault(x,0l)+1);
        }   
        Arrays.sort(arr);
        ArrayList<Long> al = new ArrayList<>();
        long res = 0, cnt = 0;
        for(Map.Entry<Long,Long> e:hm.entrySet()) {
            if((e.getValue()&1)==1) {
                al.add(e.getKey());
                res += e.getKey() * (e.getValue()-1);
                cnt += e.getValue()-1;
            }
            else {
                res += e.getKey() * e.getValue();
                cnt += e.getValue();
            }
        }
        Collections.sort(al);
        // Collections.reverse(al);
        if(al.size()==0) {
            if(cnt>=3) System.out.println(res);
            else System.out.println(0);
        }
        else if(al.size()==1) {
            if(al.get(0)<res) {
                res+=al.get(0);
                cnt++;
            }
 
            if(cnt>=3) System.out.println(res);
            else System.out.println(0);
        }
        else {
            int i = al.size()-1;
            while(i>=1) {
                if(res + al.get(i-1) > al.get(i)) {
                    res += al.get(i)+al.get(i-1);
                    cnt+=2;
 
                    if(cnt>=3) System.out.println(res);
                    else System.out.println(0);
                    return;
                }
                i--;
            }
 
            if(al.get(0) < res) {
                res += al.get(0);
                cnt++;
            }
            if(cnt>=3) System.out.println(res);
            else System.out.println(0);
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