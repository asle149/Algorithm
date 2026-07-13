import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] top) {
        int ans = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<top.length; i++) 
            map1.put(top[i], map1.getOrDefault(top[i], 0)+1);
        
        for(int i=top.length-1; i>0; i--){
            map2.put(top[i], map1.getOrDefault(top[i], 0)+1);
            if(map1.get(top[i]) == 1) map1.remove(top[i]);
            else map1.put(top[i], map1.get(top[i])-1);
            if(map1.size() == map2.size()) ans++;
        }
        
        return ans;
    }
}