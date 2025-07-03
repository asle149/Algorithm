import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
       
        System.out.println(pow(A,B,C));
    }
    
    static long pow(long A, long B, long C){
        if(B == 0) return 1;
        long half = pow(A, B/2, C);
        if(B%2 == 0) return (half*half)%C;
        else return (((half*half)%C)*A)%C;
    }
}