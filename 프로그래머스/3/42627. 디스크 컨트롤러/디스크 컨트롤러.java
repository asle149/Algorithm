import java.io.*;
import java.util.*;

class Solution {
    public static class disk{
        int i, s, l;
        public disk(int i, int s, int l){
            this.i = i;
            this.s = s;
            this.l = l;
        }
        public disk(int i, int s){
            this.i = i;
            this.s = s;
        }
    }
    
    public int solution(int[][] jobs) {
        PriorityQueue<disk> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.l != b.l) return a.l - b.l;
                if(a.s != b.s) return a.s - b.s;
                return a.i - b.i;
            }
        );
        
        PriorityQueue<disk> time = new PriorityQueue<>(
            (a, b) -> {
                return a.s - b.s;
            }
        );
        for(int i=0; i<jobs.length; i++){
            time.offer(new disk(i, jobs[i][0]));
        }
        
        int curTime = time.peek().s;
        int all = 0, cnt = 0;
        while(cnt < jobs.length){
            while(!time.isEmpty() && curTime >= time.peek().s){
                int i = time.poll().i;
                pq.offer(new disk(i, jobs[i][0], jobs[i][1]));
            }
            if(pq.isEmpty()) {curTime = time.peek().s; continue;}
            disk curD = pq.poll();
            curTime += curD.l;
            all += curTime - curD.s;
            cnt++;
        }
        
        int ans = all/jobs.length;
        return ans;
    }
}