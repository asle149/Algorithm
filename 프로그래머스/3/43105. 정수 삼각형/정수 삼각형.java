import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] tri) {
        int n = tri.length;
        int[][] dp = new int[n][n];
        dp[0][0] = tri[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + tri[i][0];
            for(int j=1; j<i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + tri[i][i];
        }
        
        int max = 0;
        for(int num : dp[n-1]){
            max = Math.max(max, num);
        }

        return max;
    }
}