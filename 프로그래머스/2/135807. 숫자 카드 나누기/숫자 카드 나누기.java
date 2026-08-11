import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0], gcdB = arrayB[0];
        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        for(int i=1; i<arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean ansA = true, ansB = true;
        for(int i=0; i<arrayA.length; i++){
            if(arrayB[i]%gcdA == 0) ansA = false;
            if(arrayA[i]%gcdB == 0) ansB = false;
        }
        
        if(ansA && ansB) return Math.max(gcdA, gcdB);
        else if(ansA && !ansB) return gcdA;
        else if(!ansA && ansB) return gcdB;
        else return 0;
    }
    
    public static int gcd(int a, int b){
        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        while(b > 0){
            int n = a%b;
            a = b;
            b = n;
        }
        
        return a;
    }
}