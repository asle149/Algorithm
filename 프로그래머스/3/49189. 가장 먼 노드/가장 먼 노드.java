import java.io.*;
import java.util.*;

class Solution {
    static int n, max;
    static ArrayList<ArrayList<Integer>> l;
   
    public int solution(int n, int[][] edge) {
        Solution.n = n;
        l = new ArrayList<>();
        for(int i=0; i<=n; i++) l.add(new ArrayList<>());

        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            (l.get(a)).add(b);
            (l.get(b)).add(a);
        }
        
        int[] dis = find();
        int ans = 0;
        for(int d : dis){
            if(max == d) ans++;
        }
        
        return ans;
    }

    public static int[] find(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int[] ans = new int[n+1];
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int node = cur[0];
            int dis = cur[1];
            ArrayList<Integer> list = l.get(node);
            for(int a : list){
                if(!visited[a]){
                    ans[a] = dis+1;
                    max = Math.max(max, ans[a]);
                    visited[a] = true;
                    q.offer(new int[]{a, dis+1});
                }
            }
        }
        
        return ans;
    }
}