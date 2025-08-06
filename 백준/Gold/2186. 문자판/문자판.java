import java.io.*;
import java.util.*;

public class Main{
    static int N, M, K;
    static char[][] map;
    static char[] word;
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    static int[][][] dp;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }
        word = br.readLine().toCharArray();
        dp = new int[N][M][word.length];
        for (int[][] row : dp){
            for (int[] col : row){
                Arrays.fill(col, -1);
            }    
        }
        
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == word[0]) {
                    answer += dfs(i, j, 0);
                }
            }
        }
        System.out.println(answer);
    }
    
    static int dfs(int x, int y, int idx){
        if (idx == word.length - 1) return 1;
        if (dp[x][y][idx] != -1) return dp[x][y][idx];
        
        dp[x][y][idx] = 0;
        for(int k=1; k<=K; k++){
           for(int d=0; d<4; d++){
               int nx = x+dx[d]*k;
               int ny = y+dy[d]*k;
                    
               if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
               if(map[nx][ny] == word[idx+1]) dp[x][y][idx] += dfs(nx, ny, idx+1);  
            }
        }
        return dp[x][y][idx];
    }
}