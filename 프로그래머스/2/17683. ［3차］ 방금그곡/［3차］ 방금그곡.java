import java.io.*;
import java.util.*;

class Solution {
    public String solution(String m, String[] musics) {
        m = change(m);
        int[] ansC = new int[musics.length];
        for(int i=0; i<musics.length; i++){
            String[] arr = musics[i].split(",");
            int start = cvrt(arr[0]);
            int finish = cvrt(arr[1]);
            int t = finish-start;
            arr[3] = change(arr[3]);
            StringBuilder sb = new StringBuilder();
            
            while(sb.length()<t) sb.append(arr[3]);
            String music = sb.substring(0, t);
            if(music.contains(m)) ansC[i] = t;
        }
        
        int max = 0;
        int ans = -1;
        for(int i=0; i<musics.length; i++){
            if(max < ansC[i]){
                ans = i;
                max = ansC[i];
            }
        }
        if(ans == -1) return "(None)";
        String[] arr = musics[ans].split(",");
        return arr[2];
    }
    
    public static int cvrt(String str){
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
    }
    
    public static String change(String str){
        str = str.replace("A#", "H");
        str = str.replace("C#", "I");
        str = str.replace("D#", "J");
        str = str.replace("F#", "K");
        str = str.replace("G#", "L");
        return str;
    }
}