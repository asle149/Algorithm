import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] parent;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i; // 따로 초기화
        }
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i, j);
                } 
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<M; i++){
            int cur = Integer.parseInt(st.nextToken());
            if(start != find(cur)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static int find(int x){
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a; 
    }
}