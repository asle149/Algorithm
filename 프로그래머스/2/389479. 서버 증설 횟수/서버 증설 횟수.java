import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] pl, int m, int k) {
        int ans = 0;
        int[] plus = new int[pl.length];
        for(int i=0; i<pl.length; i++){
            int need = pl[i]/m;
            if(plus[i]<need){
                int p = need-plus[i];
                ans += p;
                for(int j=1; j<k; j++){
                    if(i+j<pl.length) plus[i+j] += p; 
                }
            }
        }
        
        return ans;
    }
}