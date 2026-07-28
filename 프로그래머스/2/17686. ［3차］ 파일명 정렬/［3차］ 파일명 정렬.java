import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] f = new String[files.length][3];
        
        for(int i=0; i<files.length; i++){
            String str = files[i];
            int j=0;
            int nb = 0, tb = str.length();
            while(j<str.length()){
                if(Character.isDigit(str.charAt(j))) { nb = j; break; }
                j++;
            }
            while(j<str.length()){
                if(!Character.isDigit(str.charAt(j))){ tb = j; break; }
                j++;
            }
            String head = str.substring(0, nb);
            String num = str.substring(nb, tb);
            
            f[i][0] = head; 
            f[i][1] = num;
            f[i][2] = str;
        }
        
        Arrays.sort(f, (a, b) -> {
            int headCompare = a[0].compareToIgnoreCase(b[0]);

            if (headCompare != 0) {
                return headCompare;
            }

            return Integer.compare(
                Integer.parseInt(a[1]),
                Integer.parseInt(b[1])
            );
        });
        
        String[] ans = new String[files.length];
        for(int i=0; i<ans.length; i++){
            ans[i] = f[i][2];
        }
        
        return ans;
    }
}