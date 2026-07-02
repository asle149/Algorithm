import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0, r0 = 0;
        
        while(!s.equals("1")){
            int removedInRound = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '0'){
                    removedInRound++;
                    r0++;
                }
            }
            s = Integer.toBinaryString(s.length()-removedInRound);
            cnt++;
        }
        return new int[]{cnt, r0};
    }
}