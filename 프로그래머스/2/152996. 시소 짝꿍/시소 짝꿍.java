import java.io.*;
import java.util.*;

class Solution {
    public long solution(int[] w) {
        long ans = 0;
        int[] f = new int[1001];
        for(int i=0; i<w.length; i++){
            f[w[i]]++;
        }
        for(int i=100; i<1001; i++){
            if(f[i]>1) ans += (long) f[i]*(f[i]-1)/2;
            for(int j=i+1; j<1001; j++){
                if(i*3 == j*2 || i*4 == j*2 || i*4 == j*3){
                    ans += (long) f[i]*f[j];
                }
            }
        }
        
        return ans;
    }
}