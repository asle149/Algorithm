import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] num, id; //칸의 숫자, 그 칸의 타일 번호
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    static int T;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        T = N*N - N/2;
        
        num = new int[N][N*2];
        id = new int[N][N*2];
        
        int count = 0;
        boolean isOdd = true;
        int row = 0;
        int tile = 1;
        
        for(int i=1; i<=T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int start = (isOdd ? 0 : 1) + count*2; // 시작 열
            num[row][start] = Integer.parseInt(st.nextToken());;
            num[row][start+1] = Integer.parseInt(st.nextToken());;
            id[row][start] = id[row][start+1] = tile;
            tile++; count++;
            
            if(isOdd && count == N){isOdd = false; count = 0; row++;}
            else if(!isOdd && count == N-1){isOdd = true; count = 0; row++;}
        }
        bfs();
        
        sb.append(list.size()).append("\n");
        for(int t : list){
            sb.append(t).append(" ");
        }
        System.out.println(sb);
    }
    
    static int[] pair(int r, int c){
        int tid = id[r][c];
        if (c-1 >= 0 && id[r][c-1] == tid) return new int[]{r, c-1};
        else return new int[]{r, c+1};
    }
    
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[T+1];
        int[] dist = new int[T+1]; //최단거리 확인용
        int[] prev = new int[T+1]; //경로 기록용
        Arrays.fill(dist, -1);
        int bestId = 1; //최대 타일
        
        q.offer(new int[]{0, 0, 1}); //첫 x, y, 타일
        visited[1] = true;
        dist[1] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], tid = cur[2];
            
            int[] p = pair(r, c);
            int[][] cells = {{r,c}, {p[0],p[1]}}; //타일 모두 검사
            
            for(int[] cell : cells){
                int x = cell[0], y = cell[1];
                for(int d=0; d<4; d++){
                    int nx = x + dx[d], ny = y + dy[d];
                    
                    if (nx<0 || ny<0 || nx>=N || ny>=2*N) continue;
                    int nid = id[nx][ny];
                    if(nid == 0 || nid == tid || visited[nid]) continue;
                    if(num[x][y] != num[nx][ny]) continue;
                    
                    visited[nid] = true;
                    dist[nid] = dist[tid]+1;
                    prev[nid] = tid;
                    q.offer(new int[]{nx, ny, nid});
                    if (nid > bestId) bestId = nid;
                }
            }   
        }
        
        int end = (dist[T] != -1) ? T : bestId; 
        list.clear();
        for(int i=end; i!=0; i=prev[i]) list.add(i);
        Collections.reverse(list);
    }
}