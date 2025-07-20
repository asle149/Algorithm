import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] arr;
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    static boolean[][] visited;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int low = Integer.MAX_VALUE;
        int high = -1;
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                low = Math.min(low, arr[i][j]);
                high = Math.max(high, arr[i][j]);
            }
        }
        int answer = high-low;
        int left = 0;
        int right = answer;
        
        while(left<=right){
            int mid = (left+right)/2; //정답 후보
            boolean reach = false;
            
            for(int min=low; min+mid<=high; min++){
                int max = min+mid;
                if(bfs(min, max)){
                    reach = true;
                    break;
                }
            }
            
            if(reach){
                answer = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(answer);
    }
    
    static boolean bfs(int low, int high){
        if (arr[0][0] < low || arr[0][0] > high) return false;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited = new boolean[n][n]; 
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == n-1 && y == n-1) return true;
            
            for(int d=0; d<4; d++){
                int nx = x+dx[d];
                int ny = y+dy[d];
                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] < low || arr[nx][ny] > high) continue;
                
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return false;
    }
}