import java.io.*;
import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        for(int i=0; i<land[0].length; i++) dp[0][i] = land[0][i];
        
        for(int i=1; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                int max = 0;
                for(int k=0; k<land[0].length; k++){
                    if(k == j) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = max + land[i][j];
            }
        }
        
        int ans = 0;
        for(int i=0; i<land[0].length; i++) 
            ans = Math.max(ans, dp[land.length-1][i]);
        
        return ans;                       
    }
}