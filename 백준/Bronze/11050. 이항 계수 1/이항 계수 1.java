import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        System.out.println(fac(N)/(fac(K)*fac(N-K)));
    }
    
    static int fac(int num){
        if(num == 0) return 1;
        return num*fac(num-1);
    }
}