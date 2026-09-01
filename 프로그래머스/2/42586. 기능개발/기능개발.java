import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] p, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<p.length; i++){
            int time = 0;
            if(((100-p[i])%speeds[i])!=0) time++;
            time += (100-p[i])/speeds[i];
            q.offer(time);
        }
        
        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            int num = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && num >= q.peek()){
                q.poll();
                cnt++;
            }
            l.add(cnt);
        }
        
        int[] ans = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            ans[i] = l.get(i);
        }
        
        return ans;
    }
}