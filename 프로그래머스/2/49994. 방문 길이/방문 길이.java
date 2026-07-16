import java.io.*;
import java.util.*;

class Solution {
    static int[] cur = new int[2];
    static boolean[][] vRow = new boolean[11][10];
    static boolean[][] vCol = new boolean[10][11];
    static int ans = 0;
    
    public int[] dir(Character c){
        int x = cur[0];
        int y = cur[1];
        
        if(c == 'U'){
            if(x == 0) return cur;
            if(!vCol[x-1][y]) {vCol[x-1][y] = true; ans++;}
            return new int[]{x-1, y};
        }else if(c == 'D'){
            if(x == 10) return cur;
            if(!vCol[x][y]) {vCol[x][y] = true; ans++;}
            return new int[]{x+1, y};
        }else if(c == 'R'){
            if(y == 10) return cur;
            if(!vRow[x][y]) {vRow[x][y] = true; ans++;}
            return new int[]{x, y+1};
        }else{
            if(y == 0) return cur;
            if(!vRow[x][y-1]) {vRow[x][y-1] = true; ans++;}
            return new int[]{x, y-1};
        }
    }
    
    public int solution(String dirs) {
        cur[0] = 5;
        cur[1] = 5;
        
        for(int i=0; i<dirs.length(); i++){
            cur = dir(dirs.charAt(i));
        }

        return ans;
    }
}