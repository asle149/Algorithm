import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2)-> Integer.compare(o1[0], o2[0]));
        
        int end = routes[0][1];
        int ans = 0;
        for(int i=1; i<routes.length; i++){
            end = Math.min(end, routes[i][1]);
            if(routes[i][0]>end){
                ans++;
                end = routes[i][1];
            }
        }
        ans++;
        
        return ans;
    }
}