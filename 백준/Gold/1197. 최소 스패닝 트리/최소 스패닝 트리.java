import java.io.*;
import java.util.*;

public class Main{
    static int V, E, ans;
    static int[] parent;
    static List<Node> list = new ArrayList<>();
    
    static class Node{
        int a, b, c;
        Node(int a, int b, int c){
            this.a = a; this.b = b; this.c = c;
        }
    }
        
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
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        for(int i=0; i<=V; i++) parent[i] = i;
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b, c));
        }
        
        Collections.sort(list, (p, q) -> Integer.compare(p.c, q.c));
        
        for(Node n : list){
            if(find(n.a) != find(n.b)){
                union(n.a, n.b);
                ans += n.c;
            }
        }
        
        System.out.println(ans);
    }
}