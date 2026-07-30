import java.io.*;
import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    char[] num;
    
    public int solution(String numbers) {
        num = numbers.toCharArray();

        for(int i=0; i<num.length; i++){
            boolean[] visited = new boolean[num.length];
            visited[i] = true;
            makePrime(num[i]-'0', visited);
        }
        
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
        
        return;
    }
    
    public boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}