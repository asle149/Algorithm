import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<speeds.length; i++){
            int p = progresses[i];
            int s = speeds[i];
            int a = (100-p) % s == 0 ? (100-p)/s : (100-p)/s + 1;
            q.offer(a);
        }
        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            int cnt = 0;
            int last = q.poll();
            cnt++;
            while(!q.isEmpty() && last >= q.peek()){
                cnt++;
                q.poll();
            }
            l.add(cnt);
        }
        
        
        int[] answer = new int[l.size()];
        for(int i=0; i<l.size(); i++) answer[i] = l.get(i); 
        return answer;
    }
}