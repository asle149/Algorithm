class Solution {
    int n;
    int[][] computers;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];
        int ans = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i);
                ans++;
            }
        }
        
        return ans;
    }
    
    public void dfs(int num){
        visited[num] = true;
        
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[num][i] == 1) dfs(i);
        }
    }
}