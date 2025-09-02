import java.io.*;
import java.util.*;

public class Main{
    static class Edge{
        int to, weight;
        Edge(int to, int weight){
            this.to = to; this.weight = weight;
        }
    }
    
    static int V;
    static List<Edge>[] graph;
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;
                int c = Integer.parseInt(st.nextToken());
                graph[a].add(new Edge(b, c));
            }    
        }
        
        visited = new boolean[V+1];
        dfs(1, 0);
        int start = farNode;
        
        visited = new boolean[V+1];
        maxDist = 0;
        dfs(start, 0);
        
        System.out.println(maxDist);
    }
    
    static void dfs(int node, int dist){
        visited[node] = true;
        
        if(dist>maxDist){
            maxDist = dist;
            farNode = node;
        }
        
        for(Edge e : graph[node]){
            if(!visited[e.to]){
                dfs(e.to, dist+e.weight);
            }
        }
        
    }
}