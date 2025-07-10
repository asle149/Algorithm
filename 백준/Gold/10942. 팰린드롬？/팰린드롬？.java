import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] num;
    static int[][] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        
        dp = new int[N][N];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            sb.append(isP(a, b)).append('\n');            
        }
        System.out.println(sb);
    }
    
    static int isP(int a, int b){
        if(a>=b) return 1;
        if(dp[a][b] != -1) return dp[a][b];
        if (num[a] != num[b]) return dp[a][b] = 0;
        return dp[a][b] = isP(a+1, b-1);
    }
}