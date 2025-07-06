import java.io.*;
import java.util.*;

public class Main{
    static long DIV = 1000000;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        List<Long> dp = new ArrayList<>();
        long m;
        int i=2; dp.add(0L); dp.add(1L);
        
        while(true){
            dp.add((dp.get(i-1)+dp.get(i-2))%DIV);
            if (dp.get(i-1) == 0 && dp.get(i) == 1){
                m = i-1;
                break;
            }
            i++;
        }
        System.out.println(dp.get((int)(n % m)));
    }
}