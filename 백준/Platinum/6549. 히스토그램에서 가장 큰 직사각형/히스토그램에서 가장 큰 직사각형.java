import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static long[] arr;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String line = br.readLine();
            if(line.equals("0")) break;
            
            StringTokenizer st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            arr = new long[n];
            for(int i=0; i<n; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
            sb.append(getMax()).append("\n");
        }
        System.out.println(sb);
    }
    
    static long getMax(){
        Stack<Integer> s = new Stack<>();
        long max = 0;
        
        for(int i=0; i<=n; i++){
            long curH = (i == n) ? 0 : arr[i];
            while(!s.isEmpty() && arr[s.peek()] > curH){
                int top = s.pop();
                long height = arr[top];
                int width = s.isEmpty() ? i : i-s.peek()-1;
                max = Math.max(max, height * width);
            }
            s.push(i);
        }
        return max;
    }
}