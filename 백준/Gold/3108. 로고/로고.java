import java.io.*;
import java.util.*;

public class Main{     
    static int[] parent;
    static int N;
    static ArrayList<Node> arr = new ArrayList<>();
    
    static void init(int n){
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
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
        N = Integer.parseInt(br.readLine());
        
        arr.add(new Node(0, 0, 0, 0));
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            arr.add(new Node(x1, x2, y1, y2));
        }
        
        init(N+1);
        
        for(int i=0; i<N; i++){
            for(int j=1; j<=N; j++){
                if(check(arr.get(i), arr.get(j))) union(i, j);
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<=N; i++){
            set.add(find(i));
        }
        
        System.out.println(set.size()-1);
    }
    
    public static boolean check(Node a, Node b){
        //a>b
        if(b.x1>a.x1 && b.y1>a.y1 && a.x2>b.x2 && a.y2>b.y2) return false;
        //b>a
        if(b.x1<a.x1 && b.y1<a.y1 && a.x2<b.x2 && a.y2<b.y2) return false;
        //아예 안 겹침
        if(a.x1>b.x2 || a.x2<b.x1 || a.y1>b.y2 || a.y2<b.y1) return false;
        
        return true;
    }
    
}

class Node{
    int x1, x2, y1, y2;
    public Node(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}