
import java.io.*;
import java.lang.*;
import java.util.*;

public class EAddModulo10 {
    
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
        input(arr);
        int types[] = new int[4];
        Arrays.fill(types,-1);

        for(int x:arr) {
            int d = x%10;
            x/=10;
            if(d==1 || d==2 || d==4 || d==8) {
                if(types[0] == -1 || types[0]%2 == x%2) types[0] = x;
                else {
                    System.out.println("No");
                    return;
                } 

                if(types[1]!=-1 && types[0]%2 == types[1]%2) {
                    System.out.println("No");
                    return;
                } 
            }
            else if(d==3 || d==6 || d==7 || d==9) {
                if(types[1] == -1 || types[1]%2 == x%2) types[1] = x;
                else {
                    System.out.println("No");
                    return;
                }

                if(types[0]!=-1 && types[0]%2 == types[1]%2) {
                    System.out.println("No");
                    return;
                } 
            }
            else if(d==5) {
                if(types[2]==-1) types[2] = x;
                else if(types[2]!=x) {
                    System.out.println("No");
                    return;
                }

                if(types[3]!=-1 && types[3] != types[2]+1) {
                    System.out.println("No");
                    return;
                } 
            }
            else if(d==0) {
                if(types[3]==-1) types[3] = x;
                else if(types[3]!=x) {
                    System.out.println("No");
                    return;
                }

                if(types[2]!=-1 && types[3] != types[2]+1) {
                    System.out.println("No");
                    return;
                } 
            }
        }
        if((types[0]!=-1 || types[1]!=-1) && (types[2]!=-1 || types[3]!=-1)) {
            System.out.println("No");
        }
        else System.out.println("Yes");
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