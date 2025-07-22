import java.io.*;
import java.util.*;

public class Main{
    static int R, C;
    static int[] dx={-1,1,0,0}, dy={0,0,-1,1};
    static char[][] arr;
    static boolean[][] visited;
    static int mx, my, zx, zy, curX, curY;
    static int answerX, answerY;
    static Map<Character, int[]> map = new HashMap<>();
    
    static boolean isConnected(char block, int fromDir) {
        if (!map.containsKey(block)) return false;
        for (int d : map.get(block)) {
            if (d == fromDir) return true;
        }
        return false;
    }
    
    static int getOpposite(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2; // dir == 3
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        
        map.put('|', new int[]{0, 1});       // 상하
        map.put('-', new int[]{2, 3});       // 좌우
        map.put('+', new int[]{0, 1, 2, 3}); // 전방향
        map.put('1', new int[]{1, 3});       // 하, 우
        map.put('2', new int[]{0, 3});       // 상, 우
        map.put('3', new int[]{0, 2});       // 상, 좌
        map.put('4', new int[]{1, 2});       // 하, 좌
        
        arr = new char[R][C];
        
        for(int i=0; i<R; i++){
            arr[i] = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                if(arr[i][j] == 'M'){
                    mx = i; my = j;
                }else if(arr[i][j] == 'Z'){
                    zx = i; zy = j;
                }
            }
        }
           
        for(int d=0; d<4; d++){ //m에서 파악
            int nx = mx + dx[d];
            int ny = my + dy[d];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            char next = arr[nx][ny];
            if (next != '.' && isConnected(next, getOpposite(d))) { 
                curX = nx; curY= ny;
                break;
            }
        }
        
        visited = new boolean[R][C]; 
        while(true){
            visited[curX][curY] = true;
            char pipe = arr[curX][curY];
            if (pipe == '.') {
                answerX = curX;
                answerY = curY;
                break;
            }
            
            boolean moved = false;
            for(int d : map.get(pipe)){
                int nx = curX+dx[d];
                int ny = curY+dy[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(visited[nx][ny]) continue;
                if(isConnected(arr[nx][ny], getOpposite(d))){
                    visited[curX][curY] = true;
                    curX = nx; curY= ny;
                    moved = true;
                    break;
                }
            }
            if (!moved) break;
        }
        
        //정답 파이프 찾기
        char resultBlock = '?';
        outerLoop:
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '.') continue;

                List<Integer> connected = new ArrayList<>();
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

                    char neighbor = arr[nx][ny];
                    if (neighbor == '.') continue;
                    if (isConnected(neighbor, getOpposite(d))) {
                        connected.add(d);
                    }
                }

                // 후보 조건: 연결 방향이 2개 이상
                if (connected.size() >= 2 || connected.size() % 2 == 1) {
                    // 위치 저장
                    answerX = i;
                    answerY = j;

                    // 방향 기반 블록 판단
                    if (connected.size() == 4) resultBlock = '+';
                    else if (connected.contains(0) && connected.contains(1)) resultBlock = '|';
                    else if (connected.contains(2) && connected.contains(3)) resultBlock = '-';
                    else if (connected.contains(1) && connected.contains(3)) resultBlock = '1';
                    else if (connected.contains(0) && connected.contains(3)) resultBlock = '2';
                    else if (connected.contains(0) && connected.contains(2)) resultBlock = '3';
                    else if (connected.contains(1) && connected.contains(2)) resultBlock = '4';
        
                    // 종료
                    break outerLoop;
                }
            }
        }
        
        System.out.println((answerX + 1) + " " + (answerY + 1) + " " + resultBlock);
        
    }
}