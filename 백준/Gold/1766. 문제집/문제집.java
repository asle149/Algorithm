import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static List<Integer>[] l;
    static int[] in;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public static void main(String[] args)throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        l = new ArrayList[N+1];
        for(int i=0; i<=N; i++) l[i] = new ArrayList<>();
        in = new int[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            l[a].add(b);
            in[b]++;
        }
        for(int i=1; i<=N; i++){
            if(in[i] == 0){
                pq.offer(i);
            }
        }
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(" ");
            for(int next : l[cur]){
                in[next]--;
                if(in[next] == 0) pq.offer(next);
            }
        }
        System.out.println(sb.toString());
    }
}