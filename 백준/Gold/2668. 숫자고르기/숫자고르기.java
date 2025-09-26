import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] arr, state;
    static boolean[] picked;
    static List<Integer> result = new ArrayList<>();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        state = new int[N+1]; // 0=미방문, 1=방문중, 2=완료
        picked = new boolean[N+1];
        
        for(int i=1; i<=N; i++){
            if(state[i] == 0) dfs(i);
        }
        
        Collections.sort(result);
        System.out.println(result.size());
        for(int x : result) System.out.println(x);
    }
    
    
    static void dfs(int n){
        state[n] = 1;
        
        int next = arr[n];
        if(state[next] == 0) dfs(next);
        else if (state[next] == 1) {
        int cur = next;
        do{
            if (!picked[cur]){
                picked[cur] = true;
                result.add(cur);
            }
            cur = arr[cur];
        }while(cur != next);
    }    
        
        state[n] = 2;
    }
}