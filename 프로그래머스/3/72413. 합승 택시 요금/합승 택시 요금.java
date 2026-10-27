import java.io.*;
import java.util.*;


class Solution {
    static class Edge{
        int to, dis;
        Edge(int to, int dis){
            this.to = to; this.dis = dis;
        }
    }
    
    static int n;
    static List<Edge>[] l;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Solution.n = n;
        l = new ArrayList[n+1];
        for(int i=0; i<=n; i++) l[i] = new ArrayList<>();
        
        for(int i=0; i<fares.length; i++){
            int n1 = fares[i][0];
            int n2 = fares[i][1];
            int c = fares[i][2];
            l[n1].add(new Edge(n2, c));
            l[n2].add(new Edge(n1, c));
        }
        
        int[] distS = dijkstra(s);
        int[] distA = dijkstra(a);
        int[] distB = dijkstra(b);
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=n; i++){
            if(distS[i] == Integer.MAX_VALUE || distA[i] == Integer.MAX_VALUE
                || distB[i] == Integer.MAX_VALUE) continue;
            ans = Math.min(ans, distS[i] + distA[i] + distB[i]);
        }
        
        return ans;
    }
  
    public static int[] dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            if (d > dist[node]) continue;
            for(Edge e : l[node]){
                if(dist[e.to] <= d + e.dis) continue;
                dist[e.to] = d + e.dis;
                pq.offer(new int[]{e.to, dist[e.to]});
            }
        }
        
        return dist;
    }
}