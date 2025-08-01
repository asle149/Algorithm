import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //홀:상근 짝:창영
        System.out.println((N%2==1) ? "SK" : "CY");        
    }
}