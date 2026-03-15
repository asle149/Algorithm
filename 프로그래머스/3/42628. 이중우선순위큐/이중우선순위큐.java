import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] op) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i=0; i<op.length; i++){
            StringTokenizer st = new StringTokenizer(op[i]);
            String s1 = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(s1.equals("I")){
                 tm.put(num, tm.getOrDefault(num, 0) + 1);
            }else if(!tm.isEmpty()){
                if(num == 1){
                    int max = tm.lastKey();
                    if(tm.get(max) == 1) tm.pollLastEntry();
                    else tm.put(max, tm.get(max)-1);
                }else{
                    int min = tm.firstKey();
                    if(tm.get(min) == 1) tm.pollFirstEntry();
                    else tm.put(min, tm.get(min)-1);
                }
            }
        }
        int max = 0, min = 0;
        if(!tm.isEmpty()){
            max = tm.lastKey();
            min = tm.firstKey();
        }
        
        int[] ans = {max, min};
        return ans;
    }
}