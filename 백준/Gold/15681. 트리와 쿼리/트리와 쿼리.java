import java.io.*;
import java.util.*;

public class Main{
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] subtree;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        
        subtree = new int[N+1];
        dfs(R, -1);
        
        for(int i=0; i<Q; i++){
            int q = Integer.parseInt(br.readLine());
            sb.append(subtree[q]).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static int dfs(int n, int p){
        int cnt = 1;
        for(int v : tree[n]){
            if(v == p) continue;
            cnt += dfs(v, n);
        }
        return subtree[n] = cnt;
    }
}