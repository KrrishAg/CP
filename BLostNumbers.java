
import java.io.IOException;
import java.io.*;
import java.lang.*;
import java.util.*;

public class BLostNumbers {
    
    static FastScanner sc = new FastScanner();
    static long MOD = 100_000_0007;
    
    public static void main(String[] args) throws IOException {
        int arr[] = {4,8,15,16,23,42};
        System.out.println("? 1 2");
        int a = sc.nextInt();
        System.out.println("? 1 3");
        int b = sc.nextInt();
        int i,j,k,l;
        int res[] = new int[6];
        i=j=k=l=-1;
        for(int x = 0; x<6; x++) {
            for(int y = 0; y<6; y++) {
                if(x==y) continue;
                if(arr[x]*arr[y] == a) {
                    i=arr[x];
                    j=arr[y];
                }
                if(arr[x]*arr[y] == b) {
                    k=arr[x];
                    l=arr[y];
                }
            }
        }
        if(i==k || i==l) {
            res[0] = i;
            res[1] = a/i;
            res[2] = b/i;
        }
        else {
            res[0] = j;
            res[1] = a/j;
            res[2] = b/j;
        }
        
        System.out.println("? 4 5");
        a = sc.nextInt();
        System.out.println("? 4 6");
        b = sc.nextInt();
        i=j=k=l=-1;
        for(int x = 0; x<6; x++) {
            for(int y = 0; y<6; y++) {
                if(x==y) continue;
                if(arr[x]*arr[y] == a) {
                    i=arr[x];
                    j=arr[y];
                }
                if(arr[x]*arr[y] == b) {
                    k=arr[x];
                    l=arr[y];
                }
            }
        }
        if(i==k || i==l) {
            res[3] = i;
            res[4] = a/i;
            res[5] = b/i;
        }
        else {
            res[3] = j;
            res[4] = a/j;
            res[5] = b/j;
        }

        System.out.print("! ");
        for(int x:res) System.out.print(x+" ");
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