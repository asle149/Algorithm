import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static List<Integer>[] l;
    static int[] rank;
    static StringBuilder sb;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        l = (ArrayList<Integer>[]) new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            l[i] = new ArrayList<>();
        }
        rank = new int[N+1];
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l[a].add(b);
            rank[b]++;
        }
        
        bfs();
        System.out.println(sb);
    }
    
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(rank[i] == 0) q.add(i);
        }        
        
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(' '); 
            for(int num : l[cur]){
                rank[num]--;
                if(rank[num] == 0) q.add(num);
            }
        }
    }
}