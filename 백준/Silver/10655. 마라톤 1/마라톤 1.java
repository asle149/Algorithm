import java.io.*;
import java.util.*;

public class Main{
    static int[][] point;
    static int dist(int a, int b){
        return Math.abs(point[a][0]-point[b][0])+Math.abs(point[a][1]-point[b][1]);
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        point = new int[N][2];
        int all = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
            if(i!=0) all += dist(i-1, i);
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i<N-1; i++){
            int diff = dist(i-1, i+1)-(dist(i-1, i)+dist(i, i+1));
            min = Math.min(min, diff);
        }

        System.out.println(all+min);
    }
}