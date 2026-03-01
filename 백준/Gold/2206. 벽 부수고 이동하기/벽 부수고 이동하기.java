import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static Queue<int[]> q = new LinkedList<>();
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++) map[i][j] = str.charAt(j-1) - '0';
        }
        int ans = bfs();
        
        System.out.println(ans);    
    }
    
    static int bfs(){
        visited = new boolean[N+1][M+1][2];
        q.offer(new int[]{1, 1, 0, 1}); //N, M, 벽부숨여부, 거리
        visited[1][1][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            int dis = cur[3];
            if(x == N && y == M){
                return dis;
            }
            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>0 && ny>0 && nx<=N && ny<=M){
                    if(map[nx][ny] == 0){
                        if(w == 0 && !visited[nx][ny][0]){
                            visited[nx][ny][0] = true;
                            q.offer(new int[]{nx, ny, w, dis+1});
                        }else if (w == 1 && !visited[nx][ny][1]){
                            visited[nx][ny][1] = true;
                            q.offer(new int[]{nx, ny, w, dis+1});
                        }
                    }else{
                        if(!visited[nx][ny][1] && w == 0){
                            visited[nx][ny][1] = true;
                            q.offer(new int[]{nx, ny, 1, dis+1});
                        }
                    }
                }
            }  
        }
        return -1;
    }
}