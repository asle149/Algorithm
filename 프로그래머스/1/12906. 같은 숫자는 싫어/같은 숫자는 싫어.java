import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(dq.peekLast() == arr[i]) continue;
            dq.addLast(arr[i]);
        }
        int s = dq.size();
        int[] ans = new int[s];
        for(int i=0; i<s; i++){
            ans[i] = dq.pollFirst();
        }
        
        return ans;
    }
}