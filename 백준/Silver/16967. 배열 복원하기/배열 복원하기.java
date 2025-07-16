import java.io.*;
import java.util.*;

public class Main{
    static int h, w, x, y;
    static int[][] a, b;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        b = new int[h+x][w+y];
        a = new int[h][w];
        
        for(int i=0; i<h+x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w+y; j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i >= x && j >= y) {
                    a[i][j] = b[i][j] - a[i - x][j - y];
                }else{
                    a[i][j] = b[i][j];
                }
            }
        }
        
        for(int[] row : a){
            for(int n : row){
                sb.append(n).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);        
    }
}