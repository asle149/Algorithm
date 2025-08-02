import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());
        for(int i=0; i<P; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            for(int j=0; j<20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(t).append(' ').append(sort(arr)).append('\n');
        }
        System.out.println(sb);
    }
    
    static int sort(int[] arr){
        List<Integer> line = new ArrayList<>();
        int count = 0;
        for(int i=0; i<20; i++){
            int cur = arr[i];
            int pos = 0; 
            while(pos<line.size() && line.get(pos)<cur) pos++;
            count += line.size()-pos;
            line.add(pos, cur);
        }
        return count;
    }
    
}