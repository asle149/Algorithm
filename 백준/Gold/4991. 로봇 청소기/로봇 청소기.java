import java.io.*;
import java.util.*;

public class Main{
    public static class Node{
        int x, y, dist, k;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    static int w, h, k;
    static char[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    static Node robot;
    public static ArrayList<Node> dirty;
    static int answer;
    static boolean[] check;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while(!(str = br.readLine()).equals("0 0")){
            StringTokenizer st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            robot = null;
            dirty = new ArrayList<>();
            answer = Integer.MAX_VALUE;
            
            for(int i=0; i<h; i++){
                map[i] = br.readLine().toCharArray();
                for(int j=0; j<w; j++){
                    if(map[i][j] == 'o'){
                        robot = new Node(i, j);
                    }else if(map[i][j] == '*'){
                        dirty.add(new Node(i, j));
                    }
                }
            } 
            sb.append(dist()).append('\n');
        }
        System.out.println(sb);   
            
    }
    
    static int dist(){
        List<Node> positions = new ArrayList<>();
        positions.add(robot); //로봇 위치 추가
        positions.addAll(dirty); //더러운 칸 추가
        k = positions.size();
        dist = new int[k][k];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        for(int i=0; i<k; i++){
            visited = new boolean[h][w];
            Queue<Node> q = new LinkedList<>();
            Node start = positions.get(i);
            q.offer(new Node(start.x, start.y, 0));
            visited[start.x][start.y] = true;
            
            while(!q.isEmpty()){
                Node cur = q.poll();
                int x = cur.x;
                int y = cur.y;
            
                for(int d=0; d<4; d++){
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    if(nx<0 || ny<0 || nx>=h || ny>=w || 
                       visited[nx][ny] || map[nx][ny] == 'x') continue;
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, cur.dist + 1));
                
                    for(int j=0; j<k; j++){
                        Node target = positions.get(j);
                        if (target.x == nx && target.y == ny) {
                            dist[i][j] = cur.dist + 1;
                        }
                    } 
                }
            }
        }
        check = new boolean[k];
        check[0] = true;
        dfs(0, 0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    static void dfs(int depth, int prev, int total){ //방문한 dirty 갯수, 이전위치 인덱스, 거리합
       if(depth == k-1){
           answer = Math.min(answer, total);
           return;
       }
        for(int i=0; i<k; i++){
            if(check[i]) continue;
            if(dist[prev][i] == -1) continue;
            check[i] = true;
            dfs(depth+1, i, total+dist[prev][i]);  
            check[i] = false;
        }
    }
}