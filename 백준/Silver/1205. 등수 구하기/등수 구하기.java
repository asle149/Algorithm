import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        if(N == 0) {
            System.out.println(1);
            return;
        }
        
        st = new StringTokenizer(br.readLine());
        int greater = 0;
        int last = 0;
        
        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());
            if (score < cur) greater++;
            last = cur;
        }
        
        if (N == P && score <= last) {
            System.out.println(-1);
            return;
        }
        
        System.out.println(greater + 1);
	}
}