import java.io.*;
import java.util.*;

class Solution {
    public String solution(String num, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<num.length(); i++){
            char n = num.charAt(i);
            while(sb.length() != 0 && sb.charAt(sb.length()-1) < n && k>0){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(n);
        }
        
        while(k>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        
        return sb.toString();
    }
}