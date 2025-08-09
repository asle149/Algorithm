import java.io.*;
import java.util.*;

public class Main{
    static int N, K;
    static final int DIV = 1_000_000_003;
    static int[][] dp;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dp = new int[N+1][K+1];
        
        for(int i = 1; i <= N; i++){
            dp[i][1] = i;
            dp[i][0] = 1;
        }
        
        for(int i=3; i<=N; i++){
            for(int j=2; j<=K; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % DIV; //현재값 고르지 않을 때 + 고를 때
            }
        }
        
        System.out.println((dp[N-1][K] + dp[N-3][K-1]) % DIV); //원이니까 첫 칸 고르지 않을 때 + 고를 때
    }
}