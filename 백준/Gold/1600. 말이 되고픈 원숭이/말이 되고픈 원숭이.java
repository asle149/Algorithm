import java.io.*;
import java.util.*;

public class Main{
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx1 = {-1, 1, 0, 0}, dy1 = {0, 0, -1, 1};
    static int[] dx2 = {-2, -1, 1, 2, -2, -1, 1, 2},
        dy2 = {1, 2, 2, 1, -1, -2, -2, -1};
    static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs(){
        visited = new boolean[H][W][K+1];
        q.offer(new int[]{0, 0, 0, 0}); //H, W, 말처럼 횟수, 횟수
        visited[0][0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1];
            int hor = cur[2]; int cnt = cur[3];
            if(x == H-1 && y == W-1){
                return cnt;
            }
            if(hor < K){
                for(int k=0; k<8; k++){
                    int nx = x + dx2[k];
                    int ny = y + dy2[k];
                    
                    if(nx>=0 && ny>=0 && nx<H && ny<W && map[nx][ny] == 0){
                        if(!visited[nx][ny][hor+1]){
                            visited[nx][ny][hor+1] = true;
                            q.offer(new int[]{nx, ny, hor+1, cnt+1});
                        }
                    }
                }
            }
            for(int k=0; k<4; k++){
                int nx = x + dx1[k];
                int ny = y + dy1[k]; 
                if(nx>=0 && ny>=0 && nx<H && ny<W && map[nx][ny] == 0){
                    if(!visited[nx][ny][hor]){
                        visited[nx][ny][hor] = true;
                        q.offer(new int[]{nx, ny, hor, cnt+1});
                    }
                }
            }
        }
        return -1;
    }
}