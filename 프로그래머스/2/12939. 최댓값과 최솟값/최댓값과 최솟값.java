import java.util.*;

class Solution {
    public String solution(String s)  {
        StringTokenizer st = new StringTokenizer(s);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int i = Integer.parseInt(st.nextToken());
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        return min + " " + max;
    }
}