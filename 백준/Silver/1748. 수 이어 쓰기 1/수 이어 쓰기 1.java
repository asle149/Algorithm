import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long result = 0;
        long digit = 1;
        long count = 1;
        while(count * 10 <= N){
            result += digit*(count*10-count); 
            digit++;
            count *= 10;
        }
        result += digit*(N-count+1);
        System.out.println(result);
    }
}