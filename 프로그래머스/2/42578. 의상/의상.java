import java.util.*;

class Solution {
    public int solution(String[][] c) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<c.length; i++) {
            if(map.containsKey(c[i][1])) map.put(c[i][1], map.get(c[i][1])+1);
            else map.put(c[i][1], 1);
        }
        
        int ans = 1;
        for(int i : map.values()){
            ans *= (i + 1);
        }
        return ans-1;
    }
}