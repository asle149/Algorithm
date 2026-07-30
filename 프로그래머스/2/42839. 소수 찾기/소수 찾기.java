import java.io.*;
import java.util.*;

class Solution {
    static HashSet<Integer> set;
    char[] num;
    
    public int solution(String numbers) {
        num = numbers.toCharArray();
        set = new HashSet<>();

        boolean[] visited = new boolean[num.length];
        makePrime(0, visited);
        
        return set.size();
    }
    
    public void makePrime(int n, boolean[] visited){
        if(isPrime(n)) set.add(n);
        
        for(int i=0; i<visited.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            int extra = num[i] - '0';
            int newN = n*10 + extra;
            makePrime(newN, visited);
            visited[i] = false;
        }

    }
    
    public boolean isPrime(int n){
        if(n == 2) return true;
        if(n<2 || n%2 == 0) return false;
        for(int i=3; i*i<=n; i+=2){
            if(n%i == 0) return false;
        }
        return true;
    }
}