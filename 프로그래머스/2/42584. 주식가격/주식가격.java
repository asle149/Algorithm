import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[prices.length];
        for(int i=0; i<prices.length; i++){
            while(!st.isEmpty() && prices[st.peek()]>prices[i]){
                int t = st.pop();
                ans[t] = i-t;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int t = st.pop();
            ans[t] = prices.length-1-t;
        }
        
        return ans;
    }
}