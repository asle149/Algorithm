import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] m = new long[N][2]; //0:row수 1:col수
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m[i][0] = Long.parseLong(st.nextToken());
            m[i][1] = Long.parseLong(st.nextToken());
        }
        long[][][] dp = new long[N][N][3]; //dp[시작][끝][idx] 0:비용 1:row수 2:col수
        for(int i=0; i<N; i++){
            dp[i][i][1] = m[i][0];
            dp[i][i][2] = m[i][1];
        }
        for(int i=0; i<N-1; i++){
            dp[i][i+1][0] = m[i][0] * m[i][1] * m[i+1][1];
            dp[i][i+1][1] = m[i][0];
            dp[i][i+1][2] = m[i+1][1];
        }
        for(int len=3; len<=N; len++){
            for(int i=0; i<=N-len; i++){
                int j=i+len-1;
                dp[i][j][0] = Long.MAX_VALUE;
                for(int k=i; k<j; k++){
                    long cost = dp[i][k][0]+dp[k+1][j][0]+dp[i][k][1]*dp[i][k][2]*dp[k+1][j][2];
                    if(dp[i][j][0]>cost){
                        dp[i][j][0] = cost;
                        dp[i][j][1] = dp[i][k][1];
                        dp[i][j][2] = dp[k+1][j][2];
                    }
                }
            }
        }
        System.out.println(dp[0][N-1][0]);
    }
}