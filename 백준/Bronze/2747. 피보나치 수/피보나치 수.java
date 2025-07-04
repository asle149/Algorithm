import java.io.*;
import java.util.*;

public class Main{
    static int[] memo = new int[46];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fib(n));
    }
    
    static int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(memo[n] != 0) return memo[n];
        memo[n] = fib(n-1)+fib(n-2);
        return memo[n];
    }
}