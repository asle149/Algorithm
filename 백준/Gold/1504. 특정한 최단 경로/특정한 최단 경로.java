import java.io.*;
import java.util.*;

public class Main{
    static class Edge{
        int to; int dis;
        Edge(int to, int dis){
            this.to = to; this.dis = dis;
        }
    }
    
    static int N, E, v1, v2;
    static List<Edge>[] l;
    static PriorityQueue<int[]> pq;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        l = new ArrayList[N+1];
        for(int i=0; i<=N; i++) l[i] = new ArrayList<>();
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            l[a].add(new Edge(b, c));
            l[b].add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        
        long[] d1 = search(1);
        long[] dv1 = search(v1);
        long[] dv2 = search(v2);
        long l1 = d1[v1]+dv1[v2]+dv2[N]; //1->v1->v2->N
        long l2 = d1[v2]+dv2[v1]+dv1[N]; //1->v2->v1->N
        long ans = Math.min(l1, l2);
        
        if(ans >= Long.MAX_VALUE/4) System.out.println(-1);
        else System.out.println(ans);
    }
    
    static long[] search(int start){
        pq = new PriorityQueue<>((x, y) -> x[0]-y[0]);
        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE/4);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            
            if (d > dist[node]) continue; //스킵 조건
            
            for(Edge e : l[node]){
                int next = e.to;
                int ndis = e.dis;
                if(dist[next] > d+ndis){
                    dist[next] = d+ndis;
                    pq.offer(new int[]{next, d+ndis});
                }
            }
        }
        return dist;
    }
}