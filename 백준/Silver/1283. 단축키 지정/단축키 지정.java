import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static boolean[] used = new boolean[26];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String str = br.readLine();
            key(str);            
        }
        System.out.println(sb);
    }
    
    static void key(String s){
        int pick = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == ' ') {
                char c = s.charAt(i);
                if (Character.isLetter(c)) {
                int idx = Character.toLowerCase(c) - 'a';
                if (!used[idx]) { pick = i; break; }
                }
            }
        }
        if (pick == -1) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != ' ' && Character.isLetter(c)) {
                    int idx = Character.toLowerCase(c) - 'a';
                    if (!used[idx]) { pick = i; break; }
                }
            }
        }

        if (pick != -1) {
            char chosen = s.charAt(pick);
            used[Character.toLowerCase(chosen) - 'a'] = true;

            StringBuilder line = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
            if (i == pick) {
                    line.append('[').append(s.charAt(i)).append(']');
                } else {
                    line.append(s.charAt(i));
                }
            }
        sb.append(line).append('\n');
        } else {
            sb.append(s).append('\n');
        }
    }
} 