import java.io.*;
import java.util.*;

class Solution {
    static class Edge{
        int to, dis;
        Edge(int to, int dis){
            this.to = to; this.dis = dis;
        }
    }
    
    static List<Edge>[] l;
    static int n;
    static HashSet<Integer> set;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        l = new ArrayList[n+1];
        Solution.n = n;
        set = new HashSet<>();
        for(int i=0; i<summits.length; i++) set.add(summits[i]);
        for(int i=1; i<=n; i++) l[i] = new ArrayList<>();
        
        for(int i=0; i<paths.length; i++){
            int a = paths[i][0];
            int b = paths[i][1];
            int c = paths[i][2];
            l[a].add(new Edge(b, c));
            l[b].add(new Edge(a, c));
        }
        
        int ansS = 0;
        int ansD = 10_000_001;
        int[] dist = dijkstra(gates);
        
        for(int i=0; i<gates.length; i++){
            for(int j=0; j<summits.length; j++){
                if(dist[summits[j]] < ansD
                        || (dist[summits[j]] == ansD && summits[j] < ansS)){
                    ansS = summits[j];
                    ansD = dist[summits[j]];
                }
            }
        }
        
        return new int[]{ansS, ansD};
    }
    
    public static int[] dijkstra(int[] gates){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int[] dist = new int[n+1];
        Arrays.fill(dist, 10_000_001);
        for (int gate : gates){
            dist[gate] = 0;
            pq.offer(new int[]{gate, 0});
        }
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int a = cur[0];
            int b = cur[1];
            if(set.contains(a)) continue;
            if (b > dist[a]) continue;
            for(Edge e : l[a]){
                int max = Math.max(e.dis, b);
                if(dist[e.to] > max){
                    dist[e.to] = max;
                    pq.offer(new int[]{e.to, max});
                }
            }
        }
        
        return dist;
    }
}