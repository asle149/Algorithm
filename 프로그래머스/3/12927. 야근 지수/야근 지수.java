import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int i=0; i<works.length; i++) {
            pq.offer(works[i]);
        }
        
        while(n>0){
            int num = pq.poll();
            if(num == 0) return 0;
            pq.offer(num-1);
            n--;
        }
        
        long ans = 0;
        for(int num : pq){
            ans += (long) num*num;
        }
        
        return ans;
    }
}