import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T; i++){
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] file = new int[K];
            int[] sum = new int[K];
            file[0] = Integer.parseInt(st.nextToken());
            sum[0] = file[0];
            for(int j=1; j<K; j++){
                file[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j-1]+file[j];
            }
            int[][] dp = new int[K][K];
            for(int len=2; len<=K; len++){
                for(int start=0; start<=K-len; start++){
                    int end = start+len-1;
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int k=start; k<end; k++){
                        dp[start][end] = Math.min(dp[start][end], 
                                                  dp[start][k]+dp[k+1][end]
                                                  +(sum[end]-(start>0?sum[start-1]:0)));
                    }
                }
            }
            sb.append(dp[0][K-1]).append('\n');
        }
        System.out.println(sb);
    }
    
}