
import java.io.*;
import java.lang.*;
import java.util.*;

class ST {
    long seg[];
    ST(int n) {
        seg = new long[4*n];
    }
    void build(int arr[], int idx, int l, int r) {
        if(l==r) {
            seg[idx] = arr[l];
            return;
        }
        build(arr, 2*idx + 1, l, (l+r)/2); build(arr, 2*idx + 2, (l+r)/2 + 1, r);
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }
    long query(int actuall, int actualr, int l, int r, int idx) {
        //this base case or`
        if(actuall>r || actualr<l) {
            return 0;
        }
        else if(actuall<=l && r<=actualr) {
            return seg[idx];
        }
        else {
            int mid = (l+r)/2;
            return query(actuall, actualr, l, mid, 2*idx + 1) + query(actuall, actualr, mid+1, r, 2*idx + 2);
        }
    }
    //This update is adding some value to the element not chaning it.
    //This update is adding some value to the element not chaning it.
    void update(int i, int idx, int l, int r, int val) {
        if(l==r) {
            seg[idx] += val;
            return;
        }
        
        int mid = (l+r)/2;
        if(l<=i && i<=mid) update(i, 2*idx + 1, l, mid,val);
        else if(mid+1<=i && i<=r) update(i, 2*idx + 2, mid+1, r, val);
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }
}


    
    

public class CStringManipulation10 {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        // int t = sc.nextInt();
        // while(t-->0) {
            solve();
        // }
    }

    static void solve() throws IOException {
        int k = sc.nextInt();
        String s = sc.next();
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i<26; i++) al.add(new ArrayList<>());
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<k; i++) {
            str.append(s);
        }
        for(int i = 0; i<str.length(); i++) {
            al.get(str.charAt(i)-'a').add(i);
        }
        
        
        List<ST> tmp = new ArrayList<>();
        for(int i = 0; i<26; i++) {
            int n = al.get(i).size();
            tmp.add(new ST(n));
            if(n>0)
            {
                tmp.get(i).build(al.get(i), 0, 0, n-1);
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        int n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            int pos = sc.nextInt();
            char ch = sc.next().charAt(0);
            int len = al.get(ch-'a').size();

            int idx = tmp.get(ch-'a').query(0, len-1, 0, pos);
            hs.add(al.get(ch-'a').get(idx));
            tmp.get(ch-'a').update(idx,0,0,len-1,-1);
            // al.get(idx).remove(pos-1);
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<str.length(); i++) {
            if(!hs.contains(i)) res.append(str.charAt(i));
        }
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