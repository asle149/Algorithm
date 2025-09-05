import java.io.*;
import java.util.*;

public class Main{
    static long N, K, Q;
        
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            
            if(K == 1){
                sb.append(Math.abs(x-y)).append("\n");
            }else{
                int count = 0;
                
                while(x != y){
                    if(x > y){
                        x = (x-2)/K+1;
                    }else{
                        y = (y-2)/K+1;
                    }
                    count++;
                }
                sb.append(count).append("\n");                
            }
        }
        System.out.println(sb);
    }
}