import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] w;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        
        w = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) w[i] = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList[n+1];
        for(int i=1; i<=n; i++) tree[i] = new ArrayList<>();
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        
        visited = new boolean[n+1];
        dp = new int[n+1][2];
        dfs(1);
        
        int ans = Math.max(dp[1][0], dp[1][1]);
        System.out.println(ans);

        Arrays.fill(visited, false);
        trace(1, false);

        Collections.sort(result); //오름차순
        for (int x : result) sb.append(x).append(" ");
        System.out.println(sb);
    }
    
    static void dfs(int u){
        visited[u] = true;
        dp[u][0] = 0;
        dp[u][1] = w[u];
        for(int v : tree[u]){
            if(!visited[v]){
                dfs(v);
                dp[u][0] += Math.max(dp[v][0], dp[v][1]); //포함X
                dp[u][1] += dp[v][0]; //포함
            }
        }
    }
    
    static void trace(int u, boolean p){
        visited[u] = true;
        boolean ch = false;
        
        if(!p && dp[u][1] >= dp[u][0]){
            ch = true;
            result.add(u);
        }
        
        for (int v : tree[u]) {
            if (!visited[v]) {
                trace(v, ch);
            }
        }
    }
}