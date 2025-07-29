import java.io.*;
import java.util.*;

public class Main{
    static char[][] map = new char[8][8];
    static boolean[][] visited;
    static int[] dx={-1,1,0,0,-1,1,-1,1,0}, dy={0,0,-1,1,-1,1,1,-1,0};
        
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<8; i++){
            map[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs());
    }
    
    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{7,0});
        
        while(!q.isEmpty()){
            int size = q.size();
            visited = new boolean[8][8];
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (map[cur[0]][cur[1]] == '#') continue;
                for(int d=0; d<9; d++){
                    int nx = cur[0]+dx[d];
                    int ny = cur[1]+dy[d];                
                    if(nx<0 || ny<0 || nx>=8 || ny>=8 || visited[nx][ny]) continue;
                    visited[nx][ny] = true;
                    if(map[nx][ny] == '.'){
                        q.offer(new int[]{nx, ny});
                        if(nx == 0 && ny == 7) return 1;
                    }
                }
            }    
            //맵 바꾸기
            for (int i = 7; i >= 0; i--) {
                for (int j = 0; j < 8; j++) {
                    if (map[i][j] == '#') {
                        map[i][j] = '.';
                        if (i != 7) {
                            map[i + 1][j] = '#';
                        }
                    }
                }
            }
        }
        return 0;
    }
}