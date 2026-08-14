import java.io.*;
import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] g = new ArrayList[N+1];
        for(int i=1; i<=N; i++) g[i] = new ArrayList<>();
        
        for(int[] r : road){
            g[r[0]].add(new int[]{r[1], r[2]});
            g[r[1]].add(new int[]{r[0], r[2]});
        }
        
        int[] dist = dijkstra(N, g);
        int ans = 0;
        
        for(int i : dist){
            if(i<=K) ans++;
        }
        
        return ans;
    }
    
    public static int[] dijkstra(int N, List<int[]>[] g){
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[1] - y[1]));
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new int[]{1, 0}); //노드, 최소시간
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int nd = cur[0];
            int t = cur[1];
            if(t > dist[nd]) continue;
            
            for(int[] r : g[nd]){
                int nNd = r[0];
                int nT = r[1];
                
                if(dist[nNd] > t+nT){
                    dist[nNd] = t+nT;
                    pq.offer(new int[]{nNd, t+nT});
                }
            }
        }
        
        return dist;
    }
    
}