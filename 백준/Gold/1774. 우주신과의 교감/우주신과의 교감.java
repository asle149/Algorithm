import java.io.*;
import java.util.*;

public class Main{
    static class Edge {
        int u, v;
        double w;
        Edge(int u, int v, double w){ this.u=u; this.v=v; this.w=w; }
    }
    
    static int N, M;
    static int[] parent;
    static int[][] pos;
    static List<Edge> edges = new ArrayList<>();
    static double ans;
    
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b){
        int ra = find(a), rb = find(b);
        if(ra != rb) parent[rb] = ra;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0; i<=N; i++) parent[i] = i;
        
        pos = new int[N+1][2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        
        for (int i=1; i<=N; i++){
            for (int j=i+1; j<=N; j++){
                long dx = pos[i][0] - pos[j][0];
                long dy = pos[i][1] - pos[j][1];
                double dist = Math.sqrt(dx*dx + dy*dy);
                edges.add(new Edge(i, j, dist));
            }
        }
        
        Collections.sort(edges, (a, b) -> Double.compare(a.w, b.w));
        ans = 0;
        for (Edge e : edges){
            if (find(e.u) != find(e.v)){
                union(e.u, e.v);
                ans += e.w;
            }
        }
        System.out.printf("%.2f\n", ans);
    }
}