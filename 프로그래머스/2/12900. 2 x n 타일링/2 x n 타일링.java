import java.io.*;
import java.util.*;

class Solution {
    static int DIV = 1_000_000_007;
    
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 2; 
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%DIV;
        }
        
        return dp[n];        
    }
}