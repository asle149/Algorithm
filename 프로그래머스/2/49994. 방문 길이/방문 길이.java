import java.io.*;
import java.util.*;

class Solution {
    static int[] cur = new int[2];
    static HashSet<String> set = new HashSet<>();
    static int ans = 0;
    
    public int[] dir(Character c){
        int x = cur[0];
        int y = cur[1];
        int nx, ny;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(x).append(y);

        if(c == 'U'){
            if(x == 0) return cur;
            nx = x-1; ny = y;
            sb1.append(nx).append(ny);
            sb2.append(nx).append(ny).append(x).append(y);
        }else if(c == 'D'){
            if(x == 10) return cur;
            nx = x+1; ny = y;
            sb1.append(nx).append(ny);
            sb2.append(nx).append(ny).append(x).append(y);
        }else if(c == 'R'){
            if(y == 10) return cur;
            nx = x; ny = y+1;
            sb1.append(nx).append(ny);
            sb2.append(nx).append(ny).append(x).append(y);
        }else{
            if(y == 0) return cur;
            nx = x; ny = y-1;
            sb1.append(nx).append(ny);
            sb2.append(nx).append(ny).append(x).append(y);
        }
        
        boolean isNew = !set.contains(sb1.toString());
        set.add(sb1.toString());
        set.add(sb2.toString());
        
        if(isNew) ans++;
        return new int[]{nx, ny};
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