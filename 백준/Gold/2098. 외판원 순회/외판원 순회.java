import java.io.*;
import java.util.*;

public class Main{
    static final int INF = 1_000_000 * 16 + 1;
    static int N;
    static int[][] W, dp;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][1<<N];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        
        System.out.println(dfs(0, 1));
    }
    
    static int dfs(int city, int visited){
        //다 방문했으면 출발점으로 돌아감
        if (visited == (1<<N)-1){ 
            if (W[city][0] != 0) return W[city][0];
            else return INF;
        }
        
        //이미 계산된 값이 있으면 그 값 리턴
        if(dp[city][visited] != -1) return dp[city][visited]; 
        
        //아직 계산 안 됐으면
        dp[city][visited] = INF;
        for(int next=0; next<N; next++){
            if((visited & (1<<next)) == 0 && W[city][next] != 0){
                int nextVisited = visited | (1<<next); //다음 도시 방문 표시
                dp[city][visited] = Math.min(dp[city][visited], dfs(next, nextVisited)+W[city][next]);
            }
        }
        return dp[city][visited];
    }
}