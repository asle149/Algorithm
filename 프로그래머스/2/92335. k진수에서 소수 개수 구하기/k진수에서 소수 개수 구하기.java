import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String str = Integer.toString(n, k);
        String[] arr = str.split("0+");
        int ans = 0;
        
        for(int i=0; i<arr.length; i++){
            long num = Long.parseLong(arr[i]);
            if(isPrime(num)) ans++;
        }
        
        return ans;
    }
    
    public static boolean isPrime(long num){
        if(num<2) return false;
        for(long i=2; i*i<=num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}