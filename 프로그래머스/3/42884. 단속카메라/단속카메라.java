import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2)->{
            int res = Integer.compare(o1[0], o2[0]);
            if(res != 0) return res;
            return Integer.compare(o1[1], o2[1]);
        });
        
        int start = routes[0][0], end = routes[0][1];
        int ans = 0;
        for(int i=1; i<routes.length; i++){
            start = routes[i][0];
            if(end>routes[i][1]) end = routes[i][1];
            if(start>end){
                ans++;
                start = routes[i][0];
                end = routes[i][1];
            }
        }
        ans++;
        
        return ans;
    }
}