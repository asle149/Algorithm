import java.io.*;
import java.util.*;

public class Main{
    static final int DIV = 1000000007;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        System.out.println((fac(N)*pow((fac(K)*fac(N-K))%DIV, DIV-2)) % DIV);
    }
    
    static long fac(long num){
        if(num == 0) return 1;
        return num*fac(num-1) % DIV;
    }
    
    static long pow(long a, long b){
        long result = 1;
        while(b>0){
            if(b%2 == 1) result = (result*a) % DIV;
            a = (a*a) % DIV;
            b /= 2;
        }
        return result;
    }
}