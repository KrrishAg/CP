
import java.io.*;
import java.lang.*;
import java.util.*;

public class BCountSubrectangles {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = 1;
        while(t-->0) {
            solve();
        }
    }

    static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        input(a);
        input(b);

        //row x col
        List<Long> row = new ArrayList<>();
        int i = 0;
        for(; i<n; ) {
            long cnt = 0;
            while(i<n && a[i]==1) {
                cnt++;
                i++;
            }
            if(cnt>0) row.add(cnt);
            i++;
        }
        List<Long> col = new ArrayList<>();
        i = 0;
        for(; i<m; ) {
            long cnt = 0;
            while(i<m && b[i]==1) {
                cnt++;
                i++;
            }
            if(cnt>0) col.add(cnt);
            i++;
        }
        
        Collections.sort(row);
        Collections.sort(col);
        List<Long> prerow = new ArrayList<>();
        long prev = 0;
        for(long x : row) {
            prev += x;
            prerow.add(prev);
        }
        List<Long> precol = new ArrayList<>();
        prev = 0;
        for(long x : col) {
            prev += x;
            precol.add(prev);
        }

        List<Long> factArr = new ArrayList<>();
        for(long j = 1; j*j<=k; j++) {
            if(k%j == 0) factArr.add(j);
        }

        long res = 0;
        for(long currw : col) {
            for(long side1 : factArr) {
                if(currw<side1) break;
                long side2 = k/side1;
                int idx = ceil(side2, row);
                if(idx==-1) continue;
                long cnt = row.size()-idx;
                long x = prerow.getLast() - (idx==0 ? 0 : prerow.get(idx-1));
                res += (currw-side1+1) * (x-cnt*side2+cnt);
            }
        }
        for(long currh : row) {
            for(long side1 : factArr) {
                if(currh<side1) break;
                long side2 = k/side1;
                
                if(side1 == side2) continue;
                int idx = ceil(side2, col);
                if(idx==-1) continue;
                long cnt = col.size()-idx;
                long x = precol.getLast() - (idx==0 ? 0 : precol.get(idx-1));
                res += (currh-side1+1) * (x-cnt*side2+cnt);
            }
        }

        System.out.println(res);

    }

    static int ceil(long x, List<Long> al) {
        int res = -1;
        int l = 0, r = al.size()-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(al.get(mid) < x) l = mid+1;
            else {
                res = mid;
                r = mid-1;
            }
        }
        return res;
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