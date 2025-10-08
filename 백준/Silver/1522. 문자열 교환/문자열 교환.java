import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        
        int len = 0;
        for (int i = 0; i < n; i++) if (s.charAt(i) == 'a') len++;
        if (len == 0 || len == n) {
            System.out.println(0);
            return;
        }
        
        String s2 = s + s;
        char[] arr = s2.toCharArray();
        int bCnt = 0;
        for (int i = 0; i<len; i++) {
            if (arr[i] == 'b') bCnt++;
        }
        int ans = bCnt; //처음 윈도우
        
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == 'b') bCnt--;
            if (arr[i + len - 1] == 'b') bCnt++;
            ans = Math.min(ans, bCnt);
        }

        System.out.println(ans);
    }
}