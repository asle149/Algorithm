import java.io.*;
import java.util.*;

class Solution {
    public long solution(int[] seq) {
        long[][] dp = new long[seq.length][2];
        
        dp[0][0] = seq[0];
        dp[0][1] = seq[0]*-1;
        for(int i=1; i<seq.length; i++){
            dp[i][0] = Math.max(dp[i-1][1]+seq[i], seq[i]);
            dp[i][1] = Math.max(dp[i-1][0]-seq[i], seq[i]*-1);
        }
        
        long ans = 0;
        for(int i=0; i<dp.length; i++){
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }
        
        return ans;
    }
}