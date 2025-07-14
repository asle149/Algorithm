import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        int to, usado;
        Node(int to, int usado){
            this.to = to;
            this.usado = usado;
        }
    }
    static int N, Q;
    static List<Node>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[p].add(new Node(q, r));
            graph[q].add(new Node(p, r));
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            visited = new boolean[N+1];
            sb.append(dfs(k, v)).append('\n');
        }
        System.out.println(sb);
    }
    static int dfs(int k, int v){
        visited[v] = true;
        int count = 0;
        for(Node next : graph[v]){
            if(!visited[next.to] && next.usado >= k){
                count += 1+dfs(k, next.to);
            }
        }
        return count;
    }
}