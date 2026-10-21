import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int max = 0;
        for(int i=0; i<stones.length; i++) max = Math.max(max, stones[i]);

        int ans = 0;
        int left = 0;
        int right = max;
        while(left<=right){
            int n = (left+right)/2;
            int jump = 0;
            boolean check = true;
            for(int i=0; i<stones.length; i++){
                if(stones[i] < n) jump++;
                else jump = 0;
                if(jump==k) {
                    check = false;
                    break;
                }
            }
            
            if(check) {ans = n; left = n+1;}
            else right = n-1;
        }
        
        return ans;
    }
}