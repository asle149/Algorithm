import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], 0);
        }
        
        List<int[]> l = new LinkedList<>();
        int start = 0, end = map.size()-1;
        int type = 0;
        
        for(int i=start; i<=end; i++){
            if(map.get(gems[i]) == 0) type++;
            map.put(gems[i], map.get(gems[i])+1);
        }
        
        while(end<gems.length){
            if(type == map.size()){
                l.add(new int[]{start, end, end-start});
                start++;
                if(map.get(gems[start-1]) == 1) type--;
                map.put(gems[start-1], map.get(gems[start-1])-1);
            }else{
                end++;
                if(end>=gems.length) break;
                if(map.get(gems[end]) == 0) type++;
                map.put(gems[end], map.get(gems[end])+1);
            }
        }
        if(type == map.size()) l.add(new int[]{start, end, end-start});
        
        int ansS = 0, ansE = gems.length - 1;
        int min = Integer.MAX_VALUE;
        for(int[] arr : l){
            if(min>arr[2]){
                min = arr[2];
                ansS = arr[0];
                ansE = arr[1];
            }
        }
        
        return new int[]{ansS+1, ansE+1};
    }
}