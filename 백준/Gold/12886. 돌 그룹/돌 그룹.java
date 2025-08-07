import java.io.*;
import java.util.*;

public class Main{
    static int A, B, C;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        System.out.println(bfs());
    }
    
    static int bfs(){
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[1001][1001];
        int sum = A+B+C;
        if(sum%3 != 0) return 0;
        q.offer(new int[]{A, B});
        visited[A][B] = true;
        visited[B][A] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int na = cur[0];
            int nb = cur[1];
            int nc = sum-na-nb;
            if(na == nb && nb == nc) return 1;
            
            int[][] pairs = {{na, nb}, {na, nc}, {nb, nc}};
            for(int i=0; i<3; i++){
                int x = pairs[i][0];
                int y = pairs[i][1];
                if (x == y) continue;
                int nx = x>y ? x-y : 2*x;
                int ny = y>x ? y-x : 2*y;
                if(nx > 1000 || ny > 1000 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                visited[ny][nx] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return 0;    
    }
}