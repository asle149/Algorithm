import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] mem;
    static int[] cost;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mem = new int[N];
        cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            mem[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[10001]; //cost 최댓값: 10000
        for(int i=0; i<N; i++){
            for(int j=10000; j>=cost[i]; j--){
                dp[j] = Math.max(dp[j], dp[j-cost[i]]+mem[i]);
            }
        }
        for(int i=0; i<=10000; i++){
            if(dp[i]>=M){
                System.out.println(i);
                break;
            }
        }
    }
}