import java.io.*;
import java.util.*;

public class Main{
    static int N, K;
    static int[] ex;
    static boolean[] visited;
    static int count;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        ex = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            ex[i] = Integer.parseInt(st.nextToken());
        }
        
        visited = new boolean[N];
        count = 0;
        back(500, 0);
        System.out.println(count);
    }
    
    static void back(int sum, int idx){
        if(idx == N){
            count++;
            return;
        }
       
        for(int i=0; i<N; i++){
            if(!visited[i] && sum+ex[i]-K >= 500){
                visited[i] = true;
                back(sum+ex[i]-K, idx+1);
                visited[i] = false;
            }
        }
    }
}