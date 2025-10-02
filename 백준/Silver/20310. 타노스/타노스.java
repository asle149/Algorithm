import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        
        int c1 = 0, c0 = 0;
        for(int i=0; i<s.length(); i++){
            if(arr[i] == '1') c1++;
            else if(arr[i] == '0')c0++;
        }
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(arr[i] == '1'){
                arr[i] = '2';
                count++;
            }
            if(count == (c1/2)) break;
        }
        count = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(arr[i] == '0'){
                arr[i] = '2';
                count++;
            }
            if(count == (c0/2)) break;
        }
        
        for(char c : arr){
            if(c != '2') sb.append(c);
        }
        System.out.println(sb);        
    }
}