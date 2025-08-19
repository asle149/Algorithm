import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static char[][] body;
    static int hi, hj;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        body = new char[N+1][N+1];
        
        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=1; j<=N; j++){
                body[i][j] = line.charAt(j-1);
            }
        }
        
        outer:
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(body[i][j] == '*'){
                    hi = i+1; hj = j; break outer;
                }
            }
        }
        sb.append(hi).append(" ").append(hj).append('\n'); //심장 위치
        
        int al=0, ar=0;
        for(int j=1; j<=N; j++){
            if(body[hi][j] == '*'){
                if(j<hj) al++;
                else if(j>hj) ar++;
            }
        }
        sb.append(al).append(" ").append(ar); //팔 갯수
        
        int waist=0, r=hi+1;
        while (r<=N && body[r][hj]=='*'){waist++; r++;}
        sb.append(" ").append(waist); //허리 갯수
        
        int ll=0, lr=0;
        for(int i=hi+waist+1; i<=N; i++){
            if(body[i][hj-1] == '*') ll++;
            if(body[i][hj+1] == '*') lr++;
        }
        sb.append(" ").append(ll).append(" ").append(lr); //다리 갯수
        
        System.out.println(sb);
    }
}