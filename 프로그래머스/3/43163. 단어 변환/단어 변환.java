import java.io.*;
import java.util.*;

class Solution{
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    static String[] words;
    static String target;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        Solution.target = target;
        Solution.words = words;
        dfs(begin, 0);
        if(ans == Integer.MAX_VALUE) return 0;
        return ans; 
    }
    
    public void dfs(String word, int cnt){
        if(word.equals(target)) {ans = Math.min(cnt, ans); return;}
        for(int i=0; i<words.length; i++){
            int diff = 0;
            for(int j=0; j<word.length(); j++){
                if(word.charAt(j) != words[i].charAt(j)) diff++;
            }
            
            if(diff == 1 && !visited[i]){
                visited[i] = true;
                dfs(words[i], cnt+1);
                visited[i] = false;
            }
        }
        return;
    }
}