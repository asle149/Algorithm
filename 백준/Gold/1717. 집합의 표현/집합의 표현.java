import java.io.*;
import java.util.*;

public class Main{     
    static int[] parent;
    static int n, m;
    
    static void init(int n){
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }
    }
    
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB) parent[rootB] = rootA; //A에 B 연결
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        init(n+1);
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(check == 0){
                union(a, b);
            }else{
                if(find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        
        System.out.println(sb);
    }
}