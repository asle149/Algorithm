import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();
        int idx = 0;
        int i = 1;
        
        while(idx < n.length()){
            String cur = String.valueOf(i);
            for(int j=0; j<cur.length(); j++){
                if(cur.charAt(j) == n.charAt(idx)){
                    idx++;
                    if(idx == n.length()) break;
                }
            }
            i++;
        }
        System.out.println(i-1);
    }
}