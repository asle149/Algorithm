import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] pr, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<pr.length; i++){
            pq.offer(pr[i]);
        }
        
        int ans = 1;
        while(!pq.isEmpty()){
            for(int i=0; i<pr.length; i++){
                if(pr[i] == pq.peek()){
                    pq.poll();
                    if(i == location) return ans;
                    ans++;
                }
            }
        }
        
        return ans;
    }
}