import java.io.*;
import java.util.*;

public class Main{ 
    static int N;
    static int[] A;
    static int[] op = new int[4];
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, A[0]);
        System.out.println(max);
        System.out.println(min);
    }
    
    static void dfs(int idx, int num){
        if(idx == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for(int i=0; i<4; i++){
            if(op[i] == 0) continue;
            op[i]--;
            switch(i){
				case 0:	dfs(idx+1, num+A[idx]); break;
				case 1:	dfs(idx+1, num-A[idx]); break;
				case 2:	dfs(idx+1, num*A[idx]); break;
				case 3:	dfs(idx+1, num/A[idx]); break;
			}
            op[i]++;            
        }
    }
}