import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] child;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        N = Integer.parseInt(br.readLine());
        
        child = new int[26][2];
        for (int i = 0; i < 26; i++) Arrays.fill(child[i], -1);
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);
            int p = a - 'A';
            
            child[p][0] = (b == '.') ? -1 : (b - 'A');
            child[p][1] = (c == '.') ? -1 : (c - 'A');
        }
        
        pre(0);  sb.append('\n');
        in(0);   sb.append('\n');
        post(0);
        System.out.print(sb);
    }
  
    static void pre(int p){
        if (p == -1) return;
        sb.append((char)('A'+p));
        pre(child[p][0]); 
        pre(child[p][1]);
    }
    
    static void in(int p){
        if (p == -1) return;
        in(child[p][0]); 
        sb.append((char)('A'+p));
        in(child[p][1]);
    }
    
    static void post(int p){
        if (p == -1) return;
        post(child[p][0]); 
        post(child[p][1]);
        sb.append((char)('A'+p));
    }
    
}