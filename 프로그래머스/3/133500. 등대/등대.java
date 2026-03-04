import java.io.*;
import java.util.*;

class Solution {
    static int n;
    static int[][] lighthouse, dp;
    static List<Integer>[] node;
    static boolean[] visited;
    
    public int solution(int n, int[][] lighthouse) {
        this.n = n;
        this.lighthouse = lighthouse;
        node = new ArrayList[n+1];
        for(int i=1; i<=n; i++) node[i] = new ArrayList<>();
        for(int i=0; i<lighthouse.length; i++){
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            node[a].add(b);
            node[b].add(a);
        }
        dp = new int[n+1][2]; //0: 등대 꺼져있음 1: 등대 켜져있음
        visited = new boolean[n+1];
        dfs(1);
                
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    static void dfs(int num){
        visited[num] = true;
        dp[num][0] = 0;
        dp[num][1] = 1;
        
        for(int next : node[num]){
            if(!visited[next]){
                dfs(next);
                dp[num][0] += dp[next][1];
                dp[num][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}