import java.io.*;
import java.util.*;

public class Main{
    static final int DIV = 10007;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println((fac(N)*pow((fac(K)*fac(N-K))%DIV, DIV-2)) % DIV);
    }
    
    static int fac(int num){
        if(num == 0) return 1;
        return num*fac(num-1) % DIV;
    }
    
    static int pow(int a, int b){
        int result = 1;
        while(b>0){
            if(b%2 == 1) result = (result*a) % DIV;
            a = (a*a) % DIV;
            b /= 2;
        }
        return result;
    }
}