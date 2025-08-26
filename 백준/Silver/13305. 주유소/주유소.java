import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[N-1];
        int remain = 0;
        for(int i=0; i<N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
            remain += dist[i];
        }
        
        st = new StringTokenizer(br.readLine());
        int[] cost = new int[N];
        for(int i=0; i<N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        int allCost = 0;
        int cur = 0;
        for(int i=0; i<N-1; i++){
            boolean isMin = true;
            for(int j=i; j<N-1; j++){
                if(cost[i]>cost[j]) { isMin = false; continue; }
            }
            if(isMin){
                allCost += remain*cost[i];
                cur = remain;
                remain = 0;
                continue;
            }
            
            if(cur<dist[i]){
                allCost += dist[i]*cost[i];
                cur += dist[i];
                remain -= dist[i];
            }
            
            cur -= dist[i];
        }
        
        System.out.println(allCost);            
    }
}