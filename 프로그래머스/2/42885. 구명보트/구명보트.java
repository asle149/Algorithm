import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] p, int l) {
        Arrays.sort(p);
        
        int i=0, j=p.length-1;
        int ans = 0;
        while(i<=j){
            if(p[j]+p[i] <= l){
                j--;
                i++;
            }else{
                j--;
            }
            ans++;
        }
        
        return ans;
    }
}