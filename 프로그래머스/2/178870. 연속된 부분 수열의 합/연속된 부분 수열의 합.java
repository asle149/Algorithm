import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] sqc, int k) {
        int[] ans = new int[2];
        ans[0] = 0; ans[1] = sqc.length-1;
        int left = 0; int right = 0; int sum = sqc[0]; 
        
        while(left<sqc.length && right<sqc.length){
            if(sum == k){
                if(ans[1]-ans[0] > right-left){
                    ans[0] = left;
                    ans[1] = right;
                }
                sum -= sqc[left];
                left++;
                right++;
                if(right == sqc.length) break;
                sum += sqc[right];
            }else if(sum < k){
                right++;
                if(right == sqc.length) break;
                sum += sqc[right];
            }else{
                sum -= sqc[left];
                left++;
            }
        }
        
        return ans;
    }
}