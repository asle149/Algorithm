import java.io.*;
import java.util.*;

public class Main{
    static class Node{
        long x, y;
        Node(long x, long y){
            this.x = x; this.y = y;
        }
    }
    
    static long ccw(Node a, Node b, Node c){
        return (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Node a = new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Node b = new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Node c = new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Node d = new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        
        int ans = 0;
        if(ccw(a,b,c)*ccw(a,b,d)<0 && ccw(c,d,a)*ccw(c,d,b)<0) ans = 1;
        System.out.println(ans);       
    }
}