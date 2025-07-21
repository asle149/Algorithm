import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static long[] dist;
    static ArrayList<int[]> list;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, t});
        }
        
        dist = new long[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for(int i=1; i<N; i++){
            for(int[] arr : list){
                int start = arr[0];
                int end = arr[1];
                int time = arr[2];
                if(dist[start] != Integer.MAX_VALUE){
                    dist[end] = Math.min(dist[end], dist[start]+time);
                }
            }
        }
        for(int[] arr : list){ //N번째 순회로 값이 또 갱신되는지 여부 확인
            int start = arr[0];
            int end = arr[1];
            int time = arr[2];
            if(dist[start] != Integer.MAX_VALUE && dist[end]>dist[start]+time){
                System.out.println(-1);
                return;
            }
        }
        
        for (int i = 2; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("-1\n");
            else sb.append(dist[i]).append('\n');
        }
        System.out.println(sb);
    }
}