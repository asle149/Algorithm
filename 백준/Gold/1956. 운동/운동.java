import java.io.*;
import java.util.*;

public class Main{
    static int V, E;
    static int[][] dist;
        
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        dist = new int[V+1][V+1];
        for(int i=1; i<=V; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c); // 같은 간선 여러 개 있을 수 있음
        }
        
        for(int k=1; k<=V; k++) {
            for(int i=1; i<=V; i++) {
                for(int j=1; j<=V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=V; i++){
            if (dist[i][i] != Integer.MAX_VALUE) {
                min = Math.min(min, dist[i][i]); // i -> ... -> i 사이클
            }
        }
        
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
