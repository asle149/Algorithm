import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] arr;
    static int change(int i){
        if(i == 1) return 0;
        else return 1;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken())-1;
            if(a == 1) boy(s);
            else girl(s);
        }
        for(int i = 0; i < n; i++){
            sb.append(arr[i]).append(' ');
            if((i + 1) % 20 == 0) sb.append('\n');
        }
        System.out.println(sb);
    }
    
    static void boy(int s){
        for(int i=s; i<n; i+=(s+1)){
            arr[i] = change(arr[i]);
        }
    }
    
    static void girl(int s){
        int i = 1;
        arr[s] = change(arr[s]);
        while(s-i>=0 && s+i<n && arr[s-i] == arr[s+i]){
            arr[s-i] = change(arr[s-i]);
            arr[s+i] = change(arr[s+i]);
            i++;
        }
    }
}