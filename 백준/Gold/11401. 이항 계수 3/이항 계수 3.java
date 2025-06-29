import java.io.*;
import java.util.*;

public class Main{
    static final long DIV = 1000000007;
    static long[] fac;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        fac = new long[N+1];
        fac[0] = 1;
        for(int i=1; i<=N; i++){
            fac[i] = (fac[i-1]*i) % DIV;
        }
        
        System.out.println((fac[N]*pow((fac[K]*fac[N-K])%DIV, DIV-2)) % DIV);
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