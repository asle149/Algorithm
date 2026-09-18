import java.io.*;
import java.util.*;

class Solution {
    static HashSet<String> set = new HashSet<>();
    
    public int solution(String[] uid, String[] bid) {
        boolean[][] possible = new boolean[bid.length][uid.length];
            
        for(int i=0; i<bid.length; i++){
            for(int j=0; j<uid.length; j++){
                if(bid[i].length() != uid[j].length()) continue;
                boolean check = true;
                for(int k=0; k<bid[i].length(); k++){
                    if(bid[i].charAt(k) == '*') continue;
                    if(bid[i].charAt(k) != uid[j].charAt(k)){
                        check = false; break;
                    }
                }
                if(check) possible[i][j] = true;
            }
        }
        
        boolean[] used = new boolean[uid.length];
        dfs(0, possible, used);
        return set.size();
    }
    
    void dfs(int idx, boolean[][] possible, boolean[] used) {
        if (idx == possible.length) {
            set.add(Arrays.toString(used));
            return;
        }

        for (int j = 0; j < used.length; j++) {
            if (possible[idx][j] && !used[j]) {
                used[j] = true;              
                dfs(idx + 1, possible, used); 
                used[j] = false;             
            }
        }
    }   
}