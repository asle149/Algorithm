import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] btime) {
        int[] arr = new int[1001];
        int[][] bt = new int[btime.length][2];
         for(int i=0; i<bt.length; i++){
             String[] strS = btime[i][0].split(":");
             String[] endS = btime[i][1].split(":");
             int start = Integer.parseInt(strS[0])*60+Integer.parseInt(strS[1]);
             int end = Integer.parseInt(endS[0])*60+Integer.parseInt(endS[1]);
             bt[i][0] = start;
             bt[i][1] = end;
         }
        
        Arrays.sort(bt, (o1, o2) -> o1[0] - o2[0]);
        int ans = 0;

        for(int i=0; i<bt.length; i++){
            int start = bt[i][0];
            int end = bt[i][1];
            for(int j=1; j<=1000; j++){
                if(arr[j]<=start){
                    arr[j] = end+10;
                    ans = Math.max(ans, j);
                    break;
                }
            }
        }       
        
        return ans;
    }
}