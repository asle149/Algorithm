import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int a, b;
    static String[] arr;
        
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
            if(arr[i].equals("KBS1")) a = i;
            if(arr[i].equals("KBS2")) b = i;
        }
        if(a>b) b += 1;
        for(int i=0; i<a; i++){
            sb.append(1);
        }       
        for(int i=0; i<a; i++){
            sb.append(4);
        }
        for(int i=0; i<b; i++){
            sb.append(1);
        }       
        for(int i=0; i<b-1; i++){
            sb.append(4);
        }
        System.out.println(sb);
    }
}