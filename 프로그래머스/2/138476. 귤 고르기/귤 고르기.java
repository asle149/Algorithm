import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<t.length; i++){
            map.put(t[i], map.getOrDefault(t[i], 0) + 1);
        }
        
        List<Integer> l = new ArrayList<>(map.values());
        l.sort(Collections.reverseOrder());
        
        int ans = 0, cnt = 0;
        for(int i : l){
            ans++;
            cnt += i;
            if(cnt >= k) break;
        }
        
        return ans;
    }
}