import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] num;
    static char[] ops;
    static int maxAns = Integer.MIN_VALUE;
    
    static int cal(int a, int b, char op){
        int result = a;
        switch(op){
            case '+': result+=b; break;
            case '*': result*=b; break;
            case '-': result-=b; break;
        }
        return result;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N/2+1];
        ops = new char[N/2];
        String s = br.readLine();
        for(int i=0; i<N; i++){
            if(i%2 != 1) num[i/2] = s.charAt(i) - '0';
            else ops[i/2] = s.charAt(i);
        }
        
        dfs(0, num[0]); 
        
        System.out.println(maxAns);
    }
    
    static void dfs(int i, int cur){
        if(i >= N/2){
            maxAns = Math.max(maxAns, cur); return;
        }
        
        //괄호 X
        int noBl = cal(cur, num[i+1], ops[i]);
        dfs(i+1, noBl);
        
        //괄호 O
        if(i+1 < N/2){
            int inner = cal(num[i+1], num[i+2], ops[i+1]);
            int bl = cal(cur, inner, ops[i]);
            dfs(i+2, bl);
        }
    }
}