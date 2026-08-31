import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited, check;
    static int[][] coms;
    
    public int solution(int n, int[][] coms) {
        int ans = 0;
        visited = new boolean[n];
        Solution.coms = coms;
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        return ans;
    }
    
    public void dfs(int num){
        visited[num] = true;
        for(int i=0; i<coms[num].length; i++){
            if(coms[num][i] == 1 && !visited[i]) dfs(i);
        }
        return;
    }
}