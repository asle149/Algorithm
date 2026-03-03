import java.io.*;
import java.util.*;

public class Main{
    static int N, K, W;
    static int[] D, in, dp;
    static List<Integer>[] adj;
    static Queue<Integer> q;
    
    public static void main(String[] args)throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            D = new int[N+1];
            adj = new ArrayList[N+1];
            for(int j=0; j<=N; j++) adj[j] = new ArrayList<>();
            in = new int[N+1];
            for(int j=1; j<=N; j++){
                D[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a].add(b);
                in[b]++;
            }
            W = Integer.parseInt(br.readLine());
            q = new LinkedList<>();
            dp = new int[N+1];
            dp[0] = 0;
            for(int j=1; j<=N; j++){
                if(in[j] == 0){
                    q.offer(j);
                    dp[j] = D[j];
                }
            }
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next : adj[cur]){
                    dp[next] = Math.max(dp[next], dp[cur]+D[next]);
                    in[next]--;
                    if(in[next] == 0) q.offer(next);
                }
            }
            sb.append(dp[W]).append("\n");
        }
        System.out.println(sb.toString());
    }
}