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
        st = new StringTokenizer(br.readLine());
        Node c = new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Node d = new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        
        long ab1 = ccw(a, b, c);
        long ab2 = ccw(a, b, d);
        long cd1 = ccw(c, d, a);
        long cd2 = ccw(c, d, b);
        boolean crossAB = (ab1 <= 0 && ab2 >= 0) || (ab1 >= 0 && ab2 <= 0);
        boolean crossCD = (cd1 <= 0 && cd2 >= 0) || (cd1 >= 0 && cd2 <= 0);

        int ans = (crossAB && crossCD) ? 1 : 0;
        System.out.println(ans);       
    }
}