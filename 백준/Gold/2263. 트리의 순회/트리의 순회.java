import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] post;
    static Map<Integer, Integer> inMap;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        inMap = new HashMap<>();
        post = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            inMap.put(Integer.parseInt(st.nextToken()), i);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) post[i] = Integer.parseInt(st.nextToken());
        
        build(0, n-1, 0, n-1);
        System.out.println(sb);
    }
    
    static void build(int inS, int inE, int postS, int postE){
        if(inS > inE || postS > postE){
            return;
        }
        sb.append(post[postE]).append(" ");
        
        int leftSubSize = inMap.get(post[postE])-inS;
        build(inS, inMap.get(post[postE])-1, postS, postS+leftSubSize-1); //왼쪽
        build(inMap.get(post[postE])+1, inE, postS+leftSubSize, postE-1); //오른쪽
    }
}