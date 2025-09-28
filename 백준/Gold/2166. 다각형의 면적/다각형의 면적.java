import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] arr;
    static double ans;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2]; //x, y
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        arr[N][0] = arr[0][0]; arr[N][1] = arr[0][1];
        
        long sum = 0;
        for(int i=0; i<N; i++){
            sum += (long) arr[i][0]*arr[i+1][1] - (long) arr[i][1]*arr[i+1][0];
        }
        
        ans = Math.abs(sum) / 2.0;
        
        System.out.printf("%.1f", ans);
    }
}