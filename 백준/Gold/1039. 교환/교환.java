import java.io.*;
import java.util.*;

public class Main{
    
    static int N, M, K;
    static Queue<Node> q = new LinkedList<>();
    static boolean[][] visited = new boolean[1000001][11];
    static int max = -1;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        N = Integer.parseInt(s);
        M = s.length();
        K = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(max);        
    }
    
    static void bfs(){
        q.offer(new Node(String.valueOf(N), 0));
        visited[N][0] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.depth == K){
                max = Math.max(max, Integer.parseInt(cur.num));
                continue;
            }
            
            for(int i=0; i<M-1; i++){
                for(int j=i+1; j<M; j++){
                    String next = swap(cur.num, i, j);
                    if(next.charAt(0) == '0') continue;
                    
                    if(!visited[Integer.parseInt(next)][cur.depth+1]){
                        visited[Integer.parseInt(next)][cur.depth+1] = true;
                        q.offer(new Node(next, cur.depth+1));
                    }
                }
            }
            
        }
    }
    
    static String swap(String s, int i, int j){
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}

class Node {
    String num;
    int depth;

    Node(String num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}