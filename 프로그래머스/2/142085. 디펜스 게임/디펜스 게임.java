import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k, int[] e) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = e.length;
        
        for(int i=0; i<e.length; i++){
            if(pq.size()<k) pq.offer(e[i]);
            else{
                pq.offer(e[i]);
                int m = pq.poll();
                if((n-m)<0) { ans = i; break; }
                n = n-m;
            }
        }
        
        return ans;
    }
}