import java.io.*;
import java.util.*;

public class Main{
    static int N, M, h;
    static int[] arr;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        h = arr[0];
        for(int i=1; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            h = Math.max(((arr[i]-arr[i-1]+1)/2), h);
        }
        h = Math.max(h, N - arr[M-1]);
        
        System.out.println(h);
    }
}