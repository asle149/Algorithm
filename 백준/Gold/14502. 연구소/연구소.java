import java.io.*;
import java.util.*;

public class Main{
    static int N, M, wall, ans;
    static int[][] map;
    static List<int[]> virus = new ArrayList<>();
    static List<int[]> empty = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wall = 0; ans = 0;
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());  
                if(map[i][j] == 2) virus.add(new int[]{i, j});
                else if(map[i][j] == 0) empty.add(new int[]{i, j});
            }
        }
        dfs(map, 0, 0);
        System.out.println(ans);
    }
    
    static void dfs(int[][] map, int start, int idx){
        if(idx == 3){
            int size = bfs(map);
            ans = Math.max(size, ans);
            return;
        }
        for(int i=start; i<empty.size(); i++){
            int[] curE = empty.get(i);
            int ex = curE[0], ey = curE[1];
            map[ex][ey] = 1;
            dfs(map, i+1, idx+1);
            map[ex][ey] = 0;
        }
    }
    
    static int bfs(int[][] map){
        int infected = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<virus.size(); i++){
            int[] curV = virus.get(i);
            int vx = curV[0], vy = curV[1];
            q.offer(new int[]{vx, vy});
            visited[vx][vy] = true;
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int k=0; k<4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny] == 0){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    infected++;
                }
            }
        }
        return empty.size() - 3 - infected; 
    }
}