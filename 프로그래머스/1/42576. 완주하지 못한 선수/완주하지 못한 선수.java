import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] p, String[] c) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<p.length; i++){
            map1.put(p[i], map1.getOrDefault(p[i], 0)+1);
        }
        
        for(int i=0; i<c.length; i++){
            map2.put(c[i], map2.getOrDefault(c[i], 0)+1);
        }
        
        for(int i=0; i<p.length; i++){
            if(!map1.get(p[i]).equals(map2.getOrDefault(p[i], 0))){
                return p[i];
            }
        }
        
        return "";
    }
}