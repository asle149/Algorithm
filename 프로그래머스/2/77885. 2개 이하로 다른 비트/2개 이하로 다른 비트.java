import java.io.*;
import java.util.*;

class Solution {
    public long[] solution(long[] nums) {
        long[] ans = new long[nums.length];
        
        for(int i=0; i<nums.length; i++){
            Long num = nums[i];

            if(Long.bitCount(num)+1 == Long.bitCount(num+1)) ans[i] = num+1;
            else{
                int diff = Long.bitCount(num)-Long.bitCount(num+1);
                ans[i] = num + (1L << diff);
            }
        }
        
        return ans;
    }
}