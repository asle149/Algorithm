import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ')') {
                if(st.isEmpty()) return false;
                else st.pop();
            }
            else st.push('(');
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}