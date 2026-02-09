import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville) pq.offer(n);
        
        int cnt = 0;
        while(true){
            if(pq.peek() >= K) break;
            if(pq.size() < 2) return -1;
            int a = pq.poll();
            int b = pq.poll();
            int cur = a + (b*2); 
            cnt++;
            pq.offer(cur);
        }
        
        return cnt;
    }
}