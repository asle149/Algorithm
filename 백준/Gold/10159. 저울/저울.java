import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static boolean[][] arr;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        arr = new boolean[N+1][N+1];
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }
        
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(arr[i][k] && arr[k][j]) arr[i][j] = true;
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            int count = 0;
            for(int j=1; j<=N; j++){
                if (i == j) continue;
                if(!arr[i][j] && !arr[j][i]) count++;
            }
            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
    }
}