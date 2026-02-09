import java.io.*;
import java.util.*;

class Solution {
    public boolean aa(int i, int ans){
        if(i%5 == 1 && ans == 1) return true;
        if(i%5 == 2 && ans == 2) return true;
        if(i%5 == 3 && ans == 3) return true;
        if(i%5 == 4 && ans == 4) return true;
        if(i%5 == 0 && ans == 5) return true;
        return false;
    }
    public boolean bb(int i, int ans){
        if(i%2 == 1) {if(ans == 2) return true;}
        else{
            if((i/2)%4 == 1 && ans == 1) return true; 
            if((i/2)%4 == 2 && ans == 3) return true; 
            if((i/2)%4 == 3 && ans == 4) return true; 
            if((i/2)%4 == 0 && ans == 5) return true; 
        }
        return false;
    }
    
    public boolean cc(int i, int ans){
        if(((i+1)/2)%5 == 1 && ans == 3) return true;
        if(((i+1)/2)%5 == 2 && ans == 1) return true;
        if(((i+1)/2)%5 == 3 && ans == 2) return true;
        if(((i+1)/2)%5 == 4 && ans == 4) return true;
        if(((i+1)/2)%5 == 0 && ans == 5) return true;
        return false;
    }
    
    public int[] solution(int[] answer) {
        int corA = 0, corB = 0, corC = 0;
        for(int i=1; i<=answer.length; i++){
            if(aa(i, answer[i-1])) corA++;
            if(bb(i, answer[i-1])) corB++;
            if(cc(i, answer[i-1])) corC++;
        }
        
        int max = 0;
        max = Math.max(corA, Math.max(corB, corC));
        
        List<Integer> l = new ArrayList<>();
        if(corA == max) l.add(1);
        if(corB == max) l.add(2);
        if(corC == max) l.add(3);

        int[] result = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            result[i] = l.get(i); 
        }
        return result;
    }
}