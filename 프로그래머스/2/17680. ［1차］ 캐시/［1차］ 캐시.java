import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cSize, String[] c) {
        if(cSize == 0) return c.length*5;
        
        List<String> l = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int time = 0;
        
        for(int i=0; i<c.length; i++){
            String city = c[i].toLowerCase();
            
            if(set.contains(city)){
                l.remove(city);
                l.add(city);
                time++;
                continue;
            }
            
            if(set.size() >= cSize){
                set.remove(l.remove(0));
            }
            
            l.add(city);
            set.add(city);
            time += 5;
        }
        
        return time;
    }
}