import java.io.*;
import java.util.*;

public class Main{ 
    static int N, K;
    static int[] A;
    static boolean[] robot;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[2*N];
        
        for(int i=0; i<2*N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(simul());
    }
    
    static int simul(){
        int count = 0;     
        robot = new boolean[N];
        
        while(true){
            //1번
            int last = A[2*N-1];
            for(int i=2*N-1; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = last;
            
            for (int i=N-1; i>0; i--) robot[i] = robot[i-1];
            robot[0] = false;
            robot[N-1] = false;
            
            //2번
            for(int i=N-2; i>=0; i--){
                if(robot[i] && !robot[i+1] && A[i+1]>0){
                     robot[i] = false;
                     robot[i+1] = true;
                     A[i+1] = A[i+1]-1;
                }
            }
            
            //3번
            if(A[0] > 0){
                robot[0] = true;
                A[0] = A[0]-1;
            }
            
            count++;
            
            //4번
            int zero = 0;
            for(int num : A){
                if(num == 0) zero++;
            }
            if(zero>=K) return count;
        }
    }
}