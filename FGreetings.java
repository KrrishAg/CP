
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class FGreetings {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int t = sc.nextInt();
        while(t-->0) {
            solve();
        }
    }
    static long cnt = 0;
    static void solve() throws IOException {
        cnt = 0;
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for(int i = 0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i][0] = x;
            arr[i][1] = y;
        }
        Arrays.sort(arr, (p,q)->p[0]==q[0] ? q[1]-p[1] : p[0]-q[0]);
        int a[] = new int[n];
        for(int i = 0; i<n; i++) a[i] = arr[i][1];
        mergeS(0,n-1,a);
        System.out.println(cnt);
    }

    static void mergeS(int l, int r, int a[]) {
        if(r>l) {
            int mid = l+(r-l)/2;
            mergeS(l,mid,a);
            mergeS(mid+1,r,a);
            merge(l,mid,r,a);
        }
    }

    static void merge(int l, int mid, int r, int a[]) {
        int tmp[] = new int[r-l+1];
        int i = l, j = mid+1, idx = 0;
        while(i<=mid && j<=r) {
            if(a[i]<a[j]) {
                tmp[idx++] = a[i++];
            }
            else {
                cnt+=(mid-i+1);
                tmp[idx++] = a[j++];
            }
        }
        while(i<=mid) {
            tmp[idx++] = a[i++];
        }
        while(j<=r) {
            tmp[idx++] = a[j++];
        }
        for(i = 0; i<tmp.length; i++) {
            a[i+l] = tmp[i];
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