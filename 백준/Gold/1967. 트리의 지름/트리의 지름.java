import java.io.*;
import java.util.*;

public class Main{
    static class Edge{
        int to;
        int w;
        Edge(int to, int w){
            this.to = to;
            this.w = w;
        }
    }
    
    static int n, ans;
    static List<Edge>[] l;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        l = new ArrayList[n+1];
        for(int i=0; i<=n; i++) l[i] = new ArrayList<>();
        
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            l[a].add(new Edge(b, c));
            l[b].add(new Edge(a, c));
        }
        dp = new int[n+1];
        visited = new boolean[n+1];
        dfs(1);
        
        System.out.println(ans);
    }
    
    static void dfs(int num){
        visited[num] = true;
        int best1 = 0, best2 = 0;
        for(Edge e : l[num]){
            if(!visited[e.to]){
                dfs(e.to);
                int cur = dp[e.to]+e.w;
                if(cur>best1){best2 = best1; best1 = cur;}
                else if(cur>best2) best2 = cur;
            }
        }
        dp[num] = best1;
        ans = Math.max(ans, best1 + best2);
    }
}