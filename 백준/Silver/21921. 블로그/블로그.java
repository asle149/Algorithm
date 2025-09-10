import java.io.*;
import java.util.*;

public class Main{
    static int N, X, sum, count; 
    static int[] vs;     
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        vs = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            vs[i] = Integer.parseInt(st.nextToken());
            if(i<X) sum += vs[i]; 
        }
        
        int answer = sum;
        count = 1;
 
        for(int i=X; i<N; i++){
            sum += vs[i] - vs[i-X]; 
            if(answer == sum){
                count++;
            }else if(answer < sum){
                count = 1;
                answer = sum;
            }
        }
        
        if(answer == 0) System.out.println("SAD");
        else{
            System.out.println(answer);
            System.out.println(count);
        }
    }
}