import java.util.*;

class Solution {
    public String solution(String s)  {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        
        sb.append(min).append(" ").append(max);
        String answer = sb.toString();
        return answer;
    }
}