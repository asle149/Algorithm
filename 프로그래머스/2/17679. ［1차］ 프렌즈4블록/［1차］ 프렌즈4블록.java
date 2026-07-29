import java.io.*;
import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] b = new char[board.length][board[0].length()];
        for(int i=0; i<board.length; i++) b[i] = board[i].toCharArray();

        while(true){
            char[][] d = drop(b);
            if(!check(d)) break;
            
            for(int j=0; j<d[0].length; j++){
                Stack<Character> st = new Stack<>();
                for(int i=0; i<d.length; i++){
                    if(d[i][j] != '1' && d[i][j] != '0') st.push(d[i][j]);
                }
                for(int i=d.length-1; i>=0; i--){
                    if(st.isEmpty()) b[i][j] = '0';
                    else { b[i][j] = st.pop(); }
                }
            }   
        }
        
        int ans = 0;
        for(int i=0; i<b.length; i++){
            for(int j=0;j<b[0].length; j++){
                if(b[i][j] == '0') ans++;
            }
        }
        return ans;
    }
    
    public static char[][] drop(char[][] b){
        char[][] arr = new char[b.length][b[0].length];
        for(int i=0; i<arr.length; i++) arr[i] = b[i].clone();
        
        for(int i=0; i<b.length-1; i++){
            for(int j=0; j<b[0].length-1; j++){
                char c = b[i][j];
                char r = b[i][j+1];
                char d = b[i+1][j];
                char dia = b[i+1][j+1];
                if(c == '0') continue;
                if(c == r && c == d && c == dia){
                    arr[i][j] = '1'; arr[i][j+1] = '1';
                    arr[i+1][j] = '1'; arr[i+1][j+1] = '1';
                }
            }
        }
        
        return arr;
    }
    
    public static boolean check(char[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == '1') return true;
            }
        }
        return false;
    }
}