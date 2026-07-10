import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] ans = new int[(int)(right-left+1)];
        int idx = 0;
        
        for(long i=left; i<=right; i++){
            int num = Math.max((int)(i/n), (int)(i%n))+1;
            ans[idx] = num;
            idx++;
        }
        
        return ans;
    }
}