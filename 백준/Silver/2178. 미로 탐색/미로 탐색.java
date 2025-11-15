import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] arr;
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j] = line.charAt(j) - '0'; 
            }
        }
        
        System.out.println(bfs());        
    }
    
    static int bfs(){
        visited = new boolean[N][M];
        visited[0][0] = true;
        q.offer(new int[]{0, 0, 1});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            if(x == N-1 && y == M-1) return dist;
            
            for(int d=0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];               
                if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist+1});
                }
            }
        }
        return -1;
    }
}