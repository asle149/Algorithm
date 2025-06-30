import java.io.*;
import java.util.*;

public class Main{  
    static int n, m, v;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        map = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(map[i]);
        }
        
        visited = new boolean[n+1];
        dfs(v);
        System.out.println();
              
        visited = new boolean[n+1];
        bfs(v);
    }
    
    static void dfs(int now){
        visited[now] = true;
        System.out.print(now + " ");
        for (int next : map[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        
        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now + " ");
            
            for (int next : map[now]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }        
    }
}