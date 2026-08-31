import java.io.*;
import java.util.*;

class Solution {
    static int[] nums;
    static int target;
    static int ans = 0;
    
    public int solution(int[] nums, int target) {
        Solution.nums = nums;
        Solution.target = target;
        dfs(0, 0);
        return ans;
    }
    
    public void dfs(int start, int sum){
        if(start == nums.length){
            if(sum == target) ans++;
            return;
        }
        dfs(start+1, sum+nums[start]);
        dfs(start+1, sum-nums[start]);
        return;
    }
}