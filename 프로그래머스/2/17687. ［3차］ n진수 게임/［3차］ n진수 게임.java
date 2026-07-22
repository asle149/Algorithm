import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        char[] dp = new char[t*m+1];
        dp[1] = '0';
        int num = 0;
        
        for(int i=2; i<dp.length;){
            num++;
            String str = Integer.toString(num, n).toUpperCase();
            for(int j=0; j<str.length() && i<dp.length; j++){
                dp[i] = str.charAt(j);
                i++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<t*m+1; i+=m){
            sb.append(dp[i+p-1]);
        }
        
        return sb.toString();
    }
}