import java.io.*;
import java.util.*;

class Solution {
    static int max;
    static boolean[] visited;
    static int len, k;
    static int[][] dg;
    
    public int solution(int k, int[][] dg) {
        Solution.k = k;
        len = dg.length;
        Solution.dg = dg;
        visited = new boolean[len];
        
        max = 0;
        go(0, k);
        
        return max;
    }
    
    public static void go(int cnt, int energy){
        max = Math.max(cnt, max);
        for(int i=0; i<len; i++){
            if(!visited[i] && energy>=dg[i][0]){
                visited[i] = true;
                go(cnt+1, energy-dg[i][1]);
                visited[i] = false;
            }
        }
        return;
    }
}