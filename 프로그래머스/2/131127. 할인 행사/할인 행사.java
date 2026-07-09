import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] w, int[] num, String[] dc) {
        HashMap<String, Integer> wMap = new HashMap<>();
        for(int i=0; i<w.length; i++) wMap.put(w[i], num[i]);
        
        HashMap<String, Integer> dcMap = new HashMap<>();
        for(int i=0; i<10; i++){
            dcMap.put(dc[i], dcMap.getOrDefault(dc[i], 0)+1);
        }
        
        int ans = 0;
        if(check(wMap, dcMap)) ans++;
            
        for(int i=10; i<dc.length; i++){
            dcMap.put(dc[i-10], dcMap.getOrDefault(dc[i-10], 0)-1);
            dcMap.put(dc[i], dcMap.getOrDefault(dc[i], 0)+1);
            if(check(wMap, dcMap)) ans++;
        }
        
        return ans;
    }
    
    public static boolean check 
        (HashMap<String, Integer> map1, HashMap<String, Integer> map2){
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if(entry.getValue() > map2.getOrDefault(entry.getKey(), 0)) return false;
        }
        return true;
    }
}