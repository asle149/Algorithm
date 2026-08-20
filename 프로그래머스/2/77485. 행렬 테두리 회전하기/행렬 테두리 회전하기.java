import java.io.*;
import java.util.*;

class Solution {
    static int[][] arr;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] ans = new int[queries.length];
        arr = new int[rows][columns];
        int num = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++) arr[i][j] = num++;
        }
        
        for(int i=0; i<queries.length; i++){
            ans[i] = turn(queries[i]);
        }
        
        return ans;
    }
    
    public static int turn(int[] q){
        int x1 = q[0]-1, y1 = q[1]-1, x2 = q[2]-1, y2 = q[3]-1;
        int min = Integer.MAX_VALUE;
        int before = arr[x1][y1];
        int next = arr[x1][y1];
        
        for (int j = y1 + 1; j <= y2; j++) {
            min = Math.min(min, before);
            before = arr[x1][j];
            arr[x1][j] = next;
            next = before;
        }
        
        for (int i = x1 + 1; i <= x2; i++) {
            min = Math.min(min, before);
            before = arr[i][y2];
            arr[i][y2] = next;
            next = before;
        }
        
        for (int j = y2 - 1; j >= y1; j--) {
            min = Math.min(min, before);
            before = arr[x2][j];
            arr[x2][j] = next;
            next = before;
        }
        
        for (int i = x2 - 1; i >= x1; i--) {
            min = Math.min(min, before);
            before = arr[i][y1];
            arr[i][y1] = next;
            next = before;
        }
        
        return min;
    }
}