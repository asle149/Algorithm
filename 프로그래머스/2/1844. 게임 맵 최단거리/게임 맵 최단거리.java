import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            
            for(int k=0; k<4; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                
                if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length){
                    if(!visited[nx][ny] && maps[nx][ny] == 1){
                        visited[nx][ny] = true;
                    
                        if(nx == maps.length-1 && ny == maps[0].length-1) return d+1;
                        q.offer(new int[]{nx, ny, d+1});
                    }
                }
            }
        }
        
        return -1;
    }
}