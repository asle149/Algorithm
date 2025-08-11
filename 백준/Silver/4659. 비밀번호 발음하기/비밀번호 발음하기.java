import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = br.readLine();
            boolean check = false;
            if(s.equals("end")) break;
            String vowels = "aeiou";
            int countV = 0;
            int countC = 0;
            
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(vowels.indexOf(c) >= 0){
                    countV++;
                    countC = 0;
                    check = true;
                }else{
                    countC++;
                    countV = 0;
                }
                if(countC == 3 || countV == 3){
                    check = false;
                    break;
                }
                
                if(i < s.length()-1){
                    char next = s.charAt(i+1);
                    if(c == next && !(c == 'e' || c == 'o')){
                        check = false;
                        break;
                    }
                }
            }
            sb.append('<').append(s).append('>').append(" is ");
            if(check) sb.append("acceptable.\n");
            else sb.append("not acceptable.\n");
        }
        System.out.println(sb);
    }
}