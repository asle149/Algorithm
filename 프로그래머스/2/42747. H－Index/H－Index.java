import java.util.*;

class Solution {
    public int solution(int[] c) {
        Arrays.sort(c);
        int ans = 0;
        for(int i = 0; i<c.length; i++){
            if(c[i] >= c.length - i) { 
                ans = c.length - i;
                break;
            }
        }
        return ans;
    }
}