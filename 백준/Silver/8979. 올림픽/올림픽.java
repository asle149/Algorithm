import java.io.*;
import java.util.*;

public class Main{
    public static class Node{
        int name, a, b, c;
        public Node(int name, int a, int b, int c){
            this.name = name; this.a = a; this.b = b; this.c = c;
        }
    }
    
    static int N, K;
    static Node[] arr;
    static int ka, kb, kc;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new Node[N];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int name = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Node(name, a, b, c);
            if(name == K){
                ka = a; kb = b; kc = c;
            }
        }
        
        int count = 0;
        for(int i=0; i<N; i++){
            Node cur = arr[i];
            if(cur.a > ka || 
              (cur.a == ka && cur.b > kb) ||
              (cur.a == ka && cur.b == kb && cur.c > kc)) count++;
        }
        
        System.out.println(count+1);
    }
}