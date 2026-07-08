import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int i;
        set.add(words[0]);
        for(i=1; i<words.length; i++){
            if(set.contains(words[i])) break;
            String f_str = words[i-1];
            if(f_str.charAt(f_str.length()-1) != words[i].charAt(0)) break;
            set.add(words[i]);
        }
        
        int[] ans = new int[2];
        if(set.size() == words.length) return ans;
        ans[0] = i%n+1;
        ans[1] = i/n+1;
        
        return ans;
    }
}