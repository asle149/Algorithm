import java.io.*;
import java.util.*;

public class Main{
    public static class Node{
        int x, y, dir;
        public Node(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir; //0:상 1:하 2:좌 3:우
        }
    }
    
    static int N;
    static char[][] map;
    static boolean[][][] visited;
    static int[][][] dist;
    static int d1_x, d1_y, d2_x, d2_y;
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    static int[] turn(int dir) {
        if (dir == 0 || dir == 1) return new int[]{2, 3}; // 상/하 -> 좌/우
        else return new int[]{0, 1}; // 좌/우 -> 상/하
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        
        boolean found = false;
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                if(map[i][j] == '#'){
                    if (!found) {
                        d1_x = i; d1_y = j;
                        found = true;
                    } else {
                        d2_x = i; d2_y = j;
                    }
                }
            }
        }
        
        System.out.println(bfs());
        
    }
    
    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[N][N][4]; 
        dist = new int[N][N][4];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);

        for (int d = 0; d < 4; d++) {
            q.offer(new Node(d1_x, d1_y, d));
            visited[d1_x][d1_y][d] = true;
            dist[d1_x][d1_y][d] = 0;
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            while (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] != '*') {
                if (visited[nx][ny][dir]) {
                    nx += dx[dir];
                    ny += dy[dir];
                    continue;
                }

                visited[nx][ny][dir] = true;
                dist[nx][ny][dir] = Math.min(dist[nx][ny][dir], dist[x][y][dir]);

                if (map[nx][ny] == '!') {
                    for (int nd : turn(dir)) {
                        if (!visited[nx][ny][nd]) {
                            visited[nx][ny][nd] = true;
                            dist[nx][ny][nd] = Math.min(dist[nx][ny][nd], dist[x][y][dir] + 1);
                            q.offer(new Node(nx, ny, nd));
                        }
                    }
                }

                q.offer(new Node(nx, ny, dir));
                nx += dx[dir];
                ny += dy[dir];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            if (visited[d2_x][d2_y][d]) {
                min = Math.min(min, dist[d2_x][d2_y][d]);
            }
        }
        return min;
    }
}