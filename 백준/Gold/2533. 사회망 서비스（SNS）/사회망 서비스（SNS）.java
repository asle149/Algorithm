import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static ArrayList<Integer>[] l;
    static boolean[] visited;
    static int[][] dp;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        l = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) l[i] = new ArrayList<>();
        
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            l[u].add(v);
            l[v].add(u);
        }
        
        visited = new boolean[N+1];
        dp = new int[N+1][2]; //0:얼리어답터 아님 1:얼리어답터
        dfs(1);
        
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
    static void dfs(int n){
        visited[n] = true;
        dp[n][0] = 0;
        dp[n][1] = 1;
        
        for(int next : l[n]){
            if (!visited[next]){
                dfs(next);
                dp[n][0] += dp[next][1];
                dp[n][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}