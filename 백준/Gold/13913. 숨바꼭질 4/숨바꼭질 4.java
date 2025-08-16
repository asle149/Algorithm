import java.io.*;
import java.util.*;

public class Main{
    static final int max = 100001;
    static int N, K, time;
    static List<Integer> path = new ArrayList<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());      
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs();
        
        sb.append(time).append("\n");
        for(int t : path) sb.append(t).append(" ");
        System.out.println(sb);
    }
    
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        int[] dist = new int[max]; Arrays.fill(dist, -1);
        int[] prev = new int[max]; Arrays.fill(prev, -1);
        dist[N] = 0;
        q.offer(N);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            if (cur == K) break;
            int[] move = {cur+1, cur-1, cur*2};
            
            for(int n : move){
                if(n>=0 && n<max && dist[n] == -1){
                    dist[n] = dist[cur]+1;
                    prev[n] = cur;
                    q.offer(n);
                    if(n == K){
                        break;
                    }
                }
            }
        }
        
        time = dist[K];
        for(int i=K; i!=-1; i=prev[i]) path.add(i);
        Collections.reverse(path);     
    }
}