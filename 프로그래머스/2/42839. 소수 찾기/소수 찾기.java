import java.io.*;
import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static int[] num;
    static int ans = 0;
    static boolean [] visited;
    
    public boolean isPrime(int n){
        if(n<2) return false;
        if(n == 2) return true;
        if(n%2 == 0) return false;
        for(int i=3; i*i<=n; i+=2){
            if(n%i == 0) return false;
        }
        return true;
    }
    
    public int solution(String numbers) {
        num = new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++) num[i] = numbers.charAt(i)-'0';
        visited = new boolean[numbers.length()];
        dfs(0, 0);
        for(int x : set){
            if(isPrime(x)) ans++;
        }
        return ans;
    }
    
    public static void dfs(int cur, int idx){
        set.add(cur);
        if(idx == num.length) return;
        for(int i=0; i<num.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(cur*10+num[i], idx+1);
                visited[i] = false;
            }
        }
        return;
    }
}