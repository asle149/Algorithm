import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            dq.add(i);
        }
        while(dq.size() > 1){
            dq.poll();
            dq.add(dq.poll());
        }
        System.out.println(dq.poll());
    }
}