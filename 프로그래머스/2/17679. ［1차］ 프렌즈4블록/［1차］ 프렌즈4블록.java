import java.io.*;
import java.util.*;

class Solution {
    static int m, n;
    static boolean isFinish = true;
    
    public int solution(int m, int n, String[] board) {
        Solution.m = m;
        Solution.n = n;
        
        char[][] arr = new char[m][n];
        for(int i=0; i<m; i++){
            arr[i] = board[i].toCharArray();
        }
        
        while(isFinish){
            arr = next(arr);
        }
        
        int ans = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == '\u0000') ans++;
            }
        }
        
        return ans;
    }
    
    public char[][] next(char[][] arr){
        boolean[][] check = new boolean[m][n];
        isFinish = false;
        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                if(arr[i][j] == '\u0000') continue;
                char c = arr[i][j];
                if(c == arr[i][j+1] && c == arr[i+1][j] && c == arr[i+1][j+1]){
                    check[i][j] = true;
                    check[i+1][j] = true;
                    check[i][j+1] = true;
                    check[i+1][j+1] = true;
                    isFinish = true;
                }
            }
        }
        
        char[][] next = drop(arr, check);
        return next;
    }
    
    public char[][] drop(char[][] arr, boolean[][] check){
        char[][] drop = new char[m][n];
        
        for(int i=0; i<n; i++){
            int j = m-1, k = m-1;
            while(j>=0){
                if(check[j][i]) {j--; continue;}
                drop[k][i] = arr[j][i];
                k--; j--;
            }
        }
        
        return drop;
    }
}