import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] parent;
    static double[][] stars;
    static List<Node> list = new ArrayList<>();
    
    static class Node {
        int a, b;
        double d;
        Node(int a, int b, double d) {
            this.a = a; this.b = b; this.d = d;
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
        n = Integer.parseInt(br.readLine());
        
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        stars = new double[n][2];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            stars[i][0] = a; stars[i][1] = b;
        }
        
        for(int i=0; i<n; i++){
            for (int j = i + 1; j < n; j++) {
                double dx = stars[i][0] - stars[j][0];
                double dy = stars[i][1] - stars[j][1];
                double d = Math.sqrt(dx * dx + dy * dy);
                list.add(new Node(i, j, d));
            }
        }
        
        Collections.sort(list, (p, q) -> Double.compare(p.d, q.d));
        
        double result = 0;
        for(Node n : list){
            if(find(n.a) != find(n.b)){
                union(n.a, n.b);
                result += n.d;
            }
        }
        
        System.out.printf("%.2f\n", result);
    }
}