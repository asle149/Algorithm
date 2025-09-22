import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        int to, s;
        Node(int to, int s){
            this.to = to; this.s = s;
        }
    }
    
    static int t, n, d, c;
    static ArrayList<Node>[] list;
    static PriorityQueue<int[]> pq;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        
        while(t --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            list = new ArrayList[n+1];
            for (int i=1; i<=n; i++) list[i] = new ArrayList<>();

            while(d --> 0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list[b].add(new Node(a, s));
            }
            
            dijkstra();
            
            int count = 0, tMax = 0;
            for (int i=1; i<=n; i++) {
                if (dist[i] != INF) {
                    count++;
                    tMax = Math.max(tMax, dist[i]);
                }
            }
            sb.append(count).append(" ").append(tMax).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void dijkstra(){
        pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[c] = 0;
        pq.offer(new int[]{0, c}); //최소시간, 정점
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int t = cur[0], nd = cur[1];
            if(t > dist[nd]) continue;
            
            for(Node node : list[nd]){
                int to = node.to, s = node.s;
                int nt = t+s;
                if(nt < dist[to]){
                    dist[to] = nt;
                    pq.offer(new int[]{nt, to});
                }
            }
        }

    }
}