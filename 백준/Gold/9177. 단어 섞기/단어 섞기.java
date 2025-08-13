import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static char[] c1, c2, word;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            c1 = st.nextToken().toCharArray();
            c2 = st.nextToken().toCharArray();
            word = st.nextToken().toCharArray();
            sb.append("Data set ").append(i).append(": ");
            if(bfs()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }

    static boolean bfs(){
        if (c1.length + c2.length != word.length) return false;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[201][201];
        q.offer(new int[]{0, 0}); //c1 idx, c2 idx
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int idx1 = cur[0], idx2 = cur[1];
            if(idx1+idx2 == word.length) return true;
            
            if(idx1<c1.length && c1[idx1] == word[idx1+idx2] && !visited[idx1+1][idx2]){
                q.offer(new int[]{idx1+1, idx2});
                visited[idx1+1][idx2] = true;
            }
            if(idx2<c2.length && c2[idx2] == word[idx1+idx2] && !visited[idx1][idx2+1]){
                q.offer(new int[]{idx1, idx2+1});
                visited[idx1][idx2+1] = true;
            }
        }
        
        return false;
    }
}