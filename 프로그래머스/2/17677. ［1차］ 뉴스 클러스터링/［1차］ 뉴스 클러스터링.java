import java.io.*;
import java.util.*;

class Solution {
    static final int DIV = 65536;
    
    public int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i=0; i<str1.length()-1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);
            if(first < 'a' || first > 'z' || second <'a' || second > 'z') continue;
            
            String pair = str1.substring(i, i + 2);
            map1.put(pair, map1.getOrDefault(pair, 0) + 1);
        }
        for(int i=0; i<str2.length()-1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);
            if(first < 'a' || first > 'z' || second <'a' || second > 'z') continue;
        
            String pair = str2.substring(i, i + 2);
            map2.put(pair, map2.getOrDefault(pair, 0) + 1);
        }
        
        HashSet<String> set = new HashSet<>();
        
        set.addAll(map1.keySet());
        set.addAll(map2.keySet());
        
        int inter = 0;
        int union = 0;
        
        for(String s : set){
            int get1 = map1.getOrDefault(s, 0);
            int get2 = map2.getOrDefault(s, 0);
            
            inter += Math.min(get1, get2);
            union += Math.max(get1, get2);
        }
        
        if(union == 0) return DIV;
        return (int) ((double) inter / union * DIV);
    }
}