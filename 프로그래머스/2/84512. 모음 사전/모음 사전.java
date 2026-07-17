import java.io.*;
import java.util.*;

class Solution {
    static String[] d = {"A", "E", "I", "O", "U"};
    static int cnt = 0;
    static String target;
    
    public int solution(String word) {
        target = word;
        for(int i=0; i<5; i++) {
            if(recur(d[i])) break;
        }
        return cnt;
    }
    
    public static boolean recur(String cur){
        cnt++;
        if(cur.equals(target)) return true;
        if(cur.length() == 5) return false;
        for(int i=0; i<5; i++){
            if(recur(cur+d[i])) return true;
        }
        return false;
    } 
}