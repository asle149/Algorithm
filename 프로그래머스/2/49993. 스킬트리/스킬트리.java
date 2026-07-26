import java.io.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] st) {
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<skill.length(); i++) q.offer(skill.charAt(i));
        int cnt = 0;
        
        for(int i=0; i<st.length; i++){
            if(check(st[i], new LinkedList<>(q))) cnt++;
        }
        
        return cnt;
    }
    
    static boolean check(String str, Queue<Character> q){
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(q.contains(ch)){
                if(q.peek() == ch) q.poll();
                else return false;
            }
        }
        
        return true;
    }
}