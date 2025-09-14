import java.io.*;
import java.util.*;

public class Main {
    static int G, P, ans;
    static int[] parent;

    static int find(int x) {
        if (x == 0) return 0;   
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        parent[ra] = rb;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        parent = new int[G+1];
        for (int i=0; i<=G; i++) parent[i] = i; 

        ans = 0;
        for (int i=0; i<P; i++) {
            int g = Integer.parseInt(br.readLine());
            int x = find(g);
            if(x == 0) break;
            union(x, x-1);
            ans++;
        }
        
        System.out.println(ans);
    }
}
