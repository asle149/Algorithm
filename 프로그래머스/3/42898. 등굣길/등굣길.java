import java.io.*;
import java.util.*;

class Solution {
    static int div = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] p = new boolean[m+1][n+1];
        for(int[] a: puddles){
            p[a[0]][a[1]] = true; 
        }
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if (i == 1 && j == 1) continue;
                if(p[i][j]){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (dp[i-1][j]+dp[i][j-1])%div;
                }
            }
        }
        int answer = dp[m][n];
        return answer;
    }
}