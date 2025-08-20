import java.io.*;
import java.util.*;

public class Main{
    static class Edge {
        int to, cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    
    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static ArrayList<Edge>[] list;
    static int start, end;
    static PriorityQueue<int[]> pq;
    static int[] dist, prev;
    static List<Integer> path = new ArrayList<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        list = new ArrayList[n+1];
        for (int i=1; i<=n; i++) list[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        dijkstra();
        sb.append(dist[end]).append("\n");
        sb.append(path.size()).append("\n");
        for(int num : path) sb.append(num).append(" ");
        System.out.println(sb);
    }
    
    static void dijkstra(){
        pq = new PriorityQueue<>((x,y) -> Integer.compare(x[1], y[1])); //0:노드번호 1:비용
        dist = new int[n+1]; //최소비용 출발점부터 i까지
        prev = new int[n+1]; //복원용
        Arrays.fill(dist, INF); Arrays.fill(prev, -1);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1]; 
            if(cost != dist[node]) continue;
            if(node == end) break;
            
            for(Edge e : list[node]){
                int t = e.to, c = e.cost;
                int nd = cost+c;
                if(nd<dist[t]){
                    dist[t] = nd;
                    prev[t] = node;
                    pq.offer(new int[]{t, nd});
                }
            }
        }
        
        for(int i=end; i!=-1; i=prev[i]) path.add(i);
        Collections.reverse(path);
    }
}