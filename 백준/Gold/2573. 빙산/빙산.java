import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while(true){
            // 🔍 덩어리 개수부터 체크
            int cnt = cnt();

            if(cnt == 0){
                System.out.println(0);
                break;
            } else if(cnt >= 2){
                System.out.println(year);
                break;
            }

            // 🔧 빙산을 녹이고 year 증가
            melt();
            year++;
        }
    }

    static void melt(){
        int[][] nextMap = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] > 0){
                    int water = 0;
                    for(int d = 0; d < 4; d++){
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if(ni >= 0 && nj >= 0 && ni < N && nj < M){
                            if(map[ni][nj] == 0) water++;
                        }
                    }
                    nextMap[i][j] = Math.max(0, map[i][j] - water);
                }
            }
        }
        map = nextMap;
    }

    static int cnt(){
        visited = new boolean[N][M];
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] > 0 && !visited[i][j]){
                    bfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(map[nx][ny] > 0 && !visited[nx][ny]){
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
