import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    
    static int N, M;
    static Node[] points = new Node[4];
    static int[] dx={1,-1,0,0}, dy={0,0,1,-1};
    static int[][] prevX, prevY;
    static boolean[][] blocked;
    static int ans = Integer.MAX_VALUE;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Node(x, y);
        }
        solve();
        if(ans == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        else System.out.println(ans);
    }
    
    static void solve(){
        blocked = new boolean[N+1][M+1];
        Node A1 = points[0], A2 = points[1], B1 = points[2], B2 = points[3];
        
        blocked[B1.x][B1.y] = true;
        blocked[B2.x][B2.y] = true;
        int dA = bfs(A1, A2);
        if(dA != -1){
            markPath(A2);
            blocked[B1.x][B1.y] = false;
            blocked[B2.x][B2.y] = false;
            int dB = bfs(B1, B2);
            if(dB != -1) ans = Math.min(ans, dA+dB);
        }
        
        blocked = new boolean[N+1][M+1];
        blocked[A1.x][A1.y] = true;
        blocked[A2.x][A2.y] = true;
        int dB = bfs(B1, B2);
        if(dB != -1){
            markPath(B2);
            blocked[A1.x][A1.y] = false;
            blocked[A2.x][A2.y] = false;
            dA = bfs(A1, A2);
            if(dA != -1) ans = Math.min(ans, dA+dB);
        }
    }
    
    static int bfs(Node a, Node b){
        Queue<Node> q = new LinkedList<>();
        int[][] dist = new int[N+1][M+1];
        for (int i=0; i<=N; i++) Arrays.fill(dist[i], -1);
        
        prevX = new int[N+1][M+1];
        prevY = new int[N+1][M+1];
        for (int i=0; i<=N; i++) {
            Arrays.fill(prevX[i], -1);
            Arrays.fill(prevY[i], -1);
        }
        
        q.offer(new Node(a.x, a.y));
        dist[a.x][a.y] = 0;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if (cur.x == b.x && cur.y == b.y) return dist[cur.x][cur.y];
            
            for(int d=0; d<4; d++){
                int nx = cur.x+dx[d];
                int ny = cur.y+dy[d];
                if(nx < 0 || ny < 0 || nx > N || ny > M) continue;
                if(blocked[nx][ny]) continue;
                if(dist[nx][ny] != -1) continue;
                
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                prevX[nx][ny] = cur.x; prevY[nx][ny] = cur.y;
                q.offer(new Node(nx, ny));
            }
        }
        return -1;
    }
    
    static void markPath(Node a){
        int x = a.x, y = a.y;
        while(x!=-1 && y!=-1){
            blocked[x][y] = true;
            int px = prevX[x][y];
            int py = prevY[x][y];
            x = px; y = py;
        }
    }
}