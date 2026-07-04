import java.util.*;

class Solution {
    public int[] solution(int b, int y) {
        List<Integer> l = new ArrayList<>();
        for(int i=1; i*i<=y; i++){
            if(y%i == 0) l.add(i);
        }
        
        int[] ans = new int[2];
        for(int i : l){
            int j = y/i;
            if(b == j*2 + i*2 + 4){
                ans[0] = j+2;
                ans[1] = i+2;
                break;
            }
        }
        
        return ans;
    }
}