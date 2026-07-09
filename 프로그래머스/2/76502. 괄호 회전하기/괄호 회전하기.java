import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            Stack<Character> st = new Stack<>();
            for(int j=0; j<s.length(); j++){
                int idx = (i + j) % s.length();
                Character c = s.charAt(idx);
                
                if(c == '(' || c == '{' || c == '[') st.push(c);
                else{
                    if(st.empty()) {st.push(c); break;}
                    char m = st.peek();
                    if(c == ')'&& m == '(') st.pop();
                    else if(c == '}'&& m == '{') st.pop();
                    else if(c == ']'&& m == '[') st.pop();
                    else break;
                }
            }
            
            if(st.empty()) ans++;
        }
        
        return ans;
    }
}