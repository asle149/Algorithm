import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1=0, sum2=0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0; i<queue1.length; i++){
            sum1 += (long) queue1[i];
            sum2 += (long) queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        long goal = (sum1+sum2)/2;
        if((sum1+sum2)%2 != 0) return -1;
        
        int cnt = 0;
        while(true){
            if(sum1 == goal && sum2 == goal) break;
            if(q1.isEmpty() || q2.isEmpty() 
               || cnt>=queue1.length*4) return -1;
            if(sum1 > goal) {
                int n = q1.poll();
                q2.add(n);
                sum1 -= (long) n; sum2 += (long) n;
            }
            else {
                int n = q2.poll();
                q1.add(n);
                sum1 += (long) n; sum2 -= (long) n;
            }
            cnt++;
        }
        
        return cnt;
    }
}