import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        for(int i=0; i<n; i++){
            if(pq.isEmpty()) break;
            int num = pq.poll();
            if(num <= 1) continue;
            pq.offer(num-1);
        }
        
        long answer = 0;
        while(!pq.isEmpty()){
            long num = (long) pq.poll();
            answer += num*num;
        }

        return answer;
    }
}