import java.io.*;
import java.util.*;

class Solution {
    static int[] cnt;
    
    public int[] solution(int[][] arr) {
        cnt = new int[2];
        compress(arr, 0, 0, arr.length);
        return cnt;
    }
    
    public static void compress(int[][] arr, int x, int y, int size){
        if(find(arr, x, y, size)){
            cnt[arr[x][y]]++;
        }else{
            int half = size/2;
            compress(arr, x, y, half);
            compress(arr, x+half, y, half);
            compress(arr, x+half, y+half, half);
            compress(arr, x, y+half, half);
        }
        return;
    }
    
    public static boolean find(int[][] arr, int x, int y, int size){
        int num = arr[x][y];
        
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(num != arr[i][j]) return false;
            }
        }
        
        return true;
    }
}