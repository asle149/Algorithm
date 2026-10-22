import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] arr) {
        int scoreA = arr[0][0];
        int scoreB = arr[0][1];
        Arrays.sort(arr, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1]; 
            }
            return a2[0] - a1[0];
        });
        
                                      
        int max = arr[0][1];
        List<int[]> l = new ArrayList<>();
        l.add(new int[]{arr[0][0], arr[0][1], arr[0][0] + arr[0][1]});
        for(int i=1; i<arr.length; i++){
            if(max>arr[i][1] && arr[i][0] != arr[0][0]) continue;
            else{
                if(max<arr[i][1]) max = arr[i][1];
                l.add(new int[]{arr[i][0], arr[i][1], arr[i][0]+arr[i][1]});
            }
        }
        
        l.sort((a1, a2) -> a2[2] - a1[2]);
        if(l.get(0)[0] == scoreA && l.get(0)[1] == scoreB) return 1;
        int cnt = 1;
        int before = l.get(0)[2];
        for(int i=1; i<l.size(); i++){
            int[] cur = l.get(i);
            if(before != cur[2]) cnt = i+1;
            before = cur[2];
            if(cur[0] == scoreA && cur[1] == scoreB) return cnt;
        }
        
        return -1;
    }
}