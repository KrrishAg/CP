
import java.io.*;
import java.lang.*;
import java.util.*;

public class D1ConstructAnArrayEasyVersion {
    
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
        int m = sc.nextInt();    
        int arr[][] = new int[m][3];
        for(int i = 0; i<m; i++) {
            int o = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            arr[i] = new int[]{o,l,r};
        }
        boolean pos[] = new boolean[n+1];
        for(int i = 0; i<m; i++) {
            int i1 = arr[i][1], i2 = arr[i][2];
            if(i1==i2) {
                if(arr[i][0]==1) pos[i1] = true;
            }
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 1; i<=n; i++) hm.put(i,0);

        for(int i = 0; i<m; i++) {
            int i1 = arr[i][1], i2 = arr[i][2];
            if(pos[i1]!=pos[i2]) {
                int idx;
                if(arr[i][0]==1) {
                    idx = pos[i1] ? i1 : i2;
                }
                else {
                    idx = !pos[i1] ? i1 : i2;
                }
                hm.put(idx,hm.get(idx)+1);
            }
            if(arr[i][0]==1 && !pos[i1]&& !pos[i2]) {
                System.out.println("NO");
                return;
            }
            if(arr[i][0]==2 && pos[i1]&& pos[i2]) {
                System.out.println("NO");
                return;
            }
        }
        
        ArrayList<int[]> posi = new ArrayList<>();
        ArrayList<int[]> negi = new ArrayList<>();
        //idx , cnt
        for(Map.Entry<Integer,Integer> e: hm.entrySet()) {
            int k = e.getKey(), v = e.getValue();
            if(pos[k]) posi.add(new int[]{k,v});
            else negi.add(new int[]{k,v});
        }

        Collections.sort(posi, (p,q) -> p[1]-q[1]);
        Collections.sort(negi, (p,q) -> p[1]-q[1]);
        int cntp = 0, cntn = 0;
        int ip = 0, in = 0;
        int val = 1;

        int res[] = new int[n+1];
        while(ip<posi.size() && in<negi.size()) {
            if(posi.get(ip)[1] == cntn) {
                while(ip<posi.size() && posi.get(ip)[1] == cntn) {
                    int idx = posi.get(ip)[0];
                    res[idx] = val;
                    ip++;
                    cntp++;
                }
                val++;
            }
            else if(negi.get(in)[1] == cntp) {
                while(in<negi.size() && negi.get(in)[1] == cntp) {
                    int idx = negi.get(in)[0];
                    res[idx] = -val;
                    in++;
                    cntn++;
                }
                val++;
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        
        while(ip<posi.size() && posi.get(ip)[1] == cntn) {
            int idx = posi.get(ip)[0];
            res[idx] = val;
            ip++;
            cntp++;
        }
        while(in<negi.size() && negi.get(in)[1] == cntp) {
            int idx = negi.get(in)[0];
            res[idx] = -val;
            in++;
            cntn++;
        }
        if(ip!=posi.size() || in!=negi.size()) {
            System.out.println("NO");
            return;
        }
       
        System.out.println("YES");
        for(int i = 1; i<=n; i++) {
            System.out.print(res[i]+" ");
        }
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