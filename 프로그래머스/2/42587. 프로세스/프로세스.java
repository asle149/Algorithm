import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] pri, int location) {
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<pri.length; i++){
            q.offer(pri[i]);
            pq.offer(pri[i]);
        }
        
        int ans = 0;
        int loc = location;
        while(loc != -1){
            int cur = pq.peek();
            int num = 0;
            while(true){
                num = q.poll();
                if(cur == num){
                    loc--;
                    pq.poll();
                    break;
                }
                if(loc == 0) loc = loc+q.size();
                else loc--;
                q.offer(num);
            }
            ans++;
        }
        return ans;
    }
}