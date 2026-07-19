import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        st.push(0);

        for(int i=1; i<nums.length; i++){
            while (!st.isEmpty() && nums[st.peek()] < nums[i]){
                arr[st.pop()] = nums[i];
            }
            st.push(i);
        }
        
        return arr;
    }
}