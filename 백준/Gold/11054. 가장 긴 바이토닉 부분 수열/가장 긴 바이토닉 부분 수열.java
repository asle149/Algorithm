import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[][] dp = new int[N+1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            dp[i][0] = 1;
            for(int j=1; j<i; j++){
                if(arr[j]<arr[i]) dp[i][0] = Math.max(dp[j][0]+1, dp[i][0]);
            }
        }
        for (int i = N; i >= 1; i--) {
            dp[i][1] = 1;
            for (int j = i + 1; j <= N; j++) {
              if (arr[j] < arr[i]) dp[i][1] = Math.max(dp[j][1] + 1, dp[i][1]);
            }
        }
        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(dp[i][0]+dp[i][1]-1, max);
        }
        System.out.println(max);
    }
}