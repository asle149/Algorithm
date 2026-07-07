import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] e) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<e.length; i++){
            int num = 0;
            int k = i;
            for(int j=0; j<e.length; j++){
                num += e[k];
                set.add(num);
                k = (k+1) % e.length;
            }
        }
        
        return set.size();
    }
}