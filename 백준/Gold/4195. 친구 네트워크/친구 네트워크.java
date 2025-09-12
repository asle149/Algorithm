import java.io.*;
import java.util.*;

public class Main{
    static int N, F;
    static int[] parent;
    static int[] size;
    static Map<String, Integer> map;
    static int nextId;
    
    static void init(int F){
        parent = new int[2*F+1];
        size = new int[2*F+1];
        for(int i=0; i<=2*F; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static int union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return size[ra];
        parent[rb] = ra;
        size[ra] += size[rb];
        return size[ra];
    }
    
    
    static int getId(String name){
        Integer id = map.get(name);
        if (id == null){
            id = nextId++;
            map.put(name, id);
        }
        return id;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            F = Integer.parseInt(br.readLine());
            init(F);
            map = new HashMap<>();
            nextId = 0;
            for(int j=0; j<F; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                
                int ia = getId(a);
                int ib = getId(b);
                int ans = union(ia, ib);
                sb.append(ans).append('\n');
            }
        }
        System.out.print(sb);
    }
}