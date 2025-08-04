import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] areaId;
    static Map<Integer, Integer> areaMap;
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }
        bfs();
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == '0') sb.append('0');
                else sb.append(check(i, j));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        areaMap = new HashMap<>(); //key:지역 번호, value:사이즈
        areaId = new int[N][M];
        visited = new boolean[N][M];
        int areaNum = 1;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int size = 1;
                if (visited[i][j] || map[i][j] == '1') continue;
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                areaId[i][j] = areaNum;
                
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int d=0; d<4; d++){
                        int nx = cur[0]+dx[d];
                        int ny = cur[1]+dy[d];
                        if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny] == '1') continue;
                        visited[nx][ny] = true;
                        areaId[nx][ny] = areaNum;
                        q.offer(new int[]{nx, ny});
                        size++;
                    }
                }
                areaMap.put(areaNum, size); 
                areaNum++;
            }
        }
    } 
    
    static int check(int x, int y){
        int size = 1;
        Set<Integer> seen = new HashSet<>();
        for(int d=0; d<4; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx<0 || ny<0 || nx>=N || ny>=M || map[nx][ny] == '1') continue;
            
            int areaNum = areaId[nx][ny];
            if (seen.add(areaNum)) { // 중복 없으면 add + true
                size += areaMap.get(areaNum);
            }
        }
        return size % 10;
    }
} 