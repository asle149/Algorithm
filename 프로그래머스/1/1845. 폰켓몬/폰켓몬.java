import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        for(int i=0; i<len; i++) {
            set.add(nums[i]);
        }
        
        int ans = 0;
        if(len/2 > set.size()) ans = set.size();
        else ans = len/2;
            
        return ans;
    }
}