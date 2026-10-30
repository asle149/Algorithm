import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] arr = new String[files.length][4];
        for(int i=0; i<files.length; i++){
            String str = files[i];
            arr[i][0] = str;
            int j = 0;
            while(str.charAt(j)<'0' || str.charAt(j)>'9') j++;
            arr[i][1] = str.substring(0, j);
            int k = j;
            while(j < str.length() && j - k < 5 
                  && str.charAt(j)>='0' && str.charAt(j)<='9') j++;
            arr[i][2] = str.substring(k, j);
            arr[i][3] = str.substring(j, str.length());
        }
        
        Arrays.sort(arr, (a, b)->{
            int cmp = a[1].compareToIgnoreCase(b[1]);
            if(cmp == 0){
                return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);
            }
            return cmp;
        });
        
        String[] ans = new String[files.length];
        for(int i=0; i<files.length; i++){
            ans[i] = arr[i][0];
        }
        
        return ans;
    }
}