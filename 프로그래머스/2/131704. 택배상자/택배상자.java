import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int p = 0;
        
        for(int i=1; i<=order.length; i++){
            if(i == order[p]) p++;
            else sub.push(i);
            while(!sub.isEmpty() && sub.peek() == order[p]){
                sub.pop();
                p++;
            }
        }
        
        return p;
    }
}