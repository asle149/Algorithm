import java.io.*;
import java.util.*;

class Solution {
    static int ans;
    static int n;
    
    public int solution(int n) {
        ans = 0;
        Solution.n = n;
        if(n == 1) return 1;
        
        for(int i=0; i<n; i++){
            boolean[][] visited = new boolean[n][n];
            visited = check(0, i, visited);
            dfs(0, i, visited);
        }
        
        return ans;
    }
    
    public static void dfs(int x, int y, boolean[][] visited){
        for(int i=0; i<n; i++){
            if(!visited[x+1][i]){
                if(x+1 == n-1) {ans++; return;}
                boolean[][] nv = check(x+1, i, visited);
                dfs(x+1, i, nv);
            }
        }
        return;
    }
    
    public static boolean[][] check(int x, int y, boolean[][] visited){
        boolean[][] nv = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                nv[r][c] = visited[r][c];
            }
        }
        for(int i=0; i<n; i++){
            nv[i][y] = true;
            if(x+i<n && y+i<n && x+i>=0 && y+i>=0) 
                nv[x+i][y+i] = true;
            if(x+i<n && y-i<n && x+i>=0 && y-i>=0) 
                nv[x+i][y-i] = true;
            for(int j=0; j<n; j++){
                nv[x][j] = true;
            }
        }
        
        return nv;
    }
}