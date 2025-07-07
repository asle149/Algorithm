import java.io.*;
import java.util.*;

public class Main{
    static int W, H;
    static char[][] map;
    static boolean[][] visited;
    static int[] lStart, lEnd; 
    static int[] dl={-1,1,0,0}, dc={0,0,-1,1};
    static class Node {
    int l, c, dir, mirror;
    Node(int l, int c, int dir, int mirror) {
        this.l = l;
        this.c = c;
        this.dir = dir;
        this.mirror = mirror;
        }
    }
    static boolean isValid(int x, int y){
        return 0<=x && x<H && 0<=y && y<W;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        
        for(int i=0; i<H; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<W; j++){
                if(map[i][j] == 'C'){
                    if(lStart == null) lStart = new int[]{i, j};
                    else lEnd = new int[]{i, j};
                }
            }
        }
        bfs();        
    }
    
    static void bfs(){
        int[][][] dist = new int[H][W][4];
        for(int[][] row : dist){
            for(int[] d : row) Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        Queue<Node> q = new LinkedList<>();
        
        for(int d=0; d<4; d++){
            dist[lStart[0]][lStart[1]][d] = 0; //최소 거울 수 0으로 초기화
            q.offer(new Node(lStart[0], lStart[1], d, 0)); //이동 가능한 출발점 큐 등록
        }
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int d=0; d<4; d++){
                int nl = cur.l + dl[d];
                int nc = cur.c + dc[d];
                
                if(isValid(nl, nc) && map[nl][nc] != '*'){
                    int newMirror = cur.mirror + (cur.dir == d ? 0:1);
                    
                    if(dist[nl][nc][d] > newMirror){
                        dist[nl][nc][d] = newMirror;
                        q.offer(new Node(nl, nc, d, newMirror));
                    }                    
                }
            } 
        }
        
        int answer = Integer.MAX_VALUE;
        for(int d=0; d<4; d++){
            answer = Math.min(answer, dist[lEnd[0]][lEnd[1]][d]);
        }
        System.out.println(answer);
    }
    
}