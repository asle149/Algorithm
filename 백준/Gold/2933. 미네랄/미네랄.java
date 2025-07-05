import java.io.*;
import java.util.*;

public class Main{
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int h = R - Integer.parseInt(st.nextToken());
            if(i%2==0){
                for(int j=0; j<C; j++){
                    if(map[h][j] == 'x'){
                        map[h][j] = '.';
                        break;
                    }
                }
            }else{
                for(int j=C-1; j>=0; j--){
                    if(map[h][j] == 'x'){
                        map[h][j] = '.';
                        break;
                    }
                }
            }
            clus();        
        }
        StringBuilder sb = new StringBuilder();
        for(char arr[] : map){
            for(char c : arr){
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    
    static void clus(){
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j] == 'x' && !visited[i][j]){
                    List<int[]> cluster = new ArrayList<>();
                    if(!isGround(i, j, cluster)){
                        grav(cluster);
                        return;
                    }
                }
            }
        }
    }
    
    static boolean isGround(int i, int j, List<int[]> cluster){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        boolean ground = false;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            cluster.add(new int[]{x, y});
            if(x == R-1) ground = true;
            
            for(int d=0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx<0 || ny<0 || nx>=R || ny>=C || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if(map[nx][ny] == 'x'){
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return ground;       
    }
    
    static void grav(List<int[]> cluster){
        int move = 1;
        for(int[] pos : cluster) {
            map[pos[0]][pos[1]] = '.';
        }

        outer:
        while(true){
            for(int[] pos : cluster){
                if(pos[0]+move >= R || map[pos[0]+move][pos[1]] == 'x'){
                    move--;
                    break outer;
                }
            }
            move++;
        }

        for(int[] pos : cluster) {
            map[pos[0]+move][pos[1]] = 'x';
        }
        
        return;
    }
}
