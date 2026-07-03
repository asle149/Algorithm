import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int cnt1 = 0;
        String str = Integer.toBinaryString(n);
        for(int i=0; i<str.length(); i++) if(str.charAt(i) == '1') cnt1++;
        
        int ans = n;
        while(true){
            int cnt2 = 0; 
            ans++;
            String str2 = Integer.toBinaryString(ans);
            for(int i=0; i<str2.length(); i++) if(str2.charAt(i) == '1') cnt2++;
            if(cnt1 == cnt2) break;           
        }
        
        return ans;
    }
}