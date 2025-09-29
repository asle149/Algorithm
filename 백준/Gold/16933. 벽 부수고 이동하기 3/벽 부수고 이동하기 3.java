import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] arr;
    static int ans = -1;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        bfs();
        System.out.println(ans);
    }

    // 큐에 담는 상태: {x, y, moveCnt(거리), brokenCnt(부순 벽 수)}
    static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        Integer[][] visit = new Integer[N][M];  // 해당 칸에 도달할 때의 최소 부순 벽 수만 저장

        q.offer(new int[]{0, 0, 1, 0}); // 시작 (0,0), 거리=1, 부순벽=0

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], moveCnt = cur[2], brokenCnt = cur[3];

            if (x == N - 1 && y == M - 1) {
                ans = moveCnt;
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (arr[nx][ny] == '1') { // 벽
                    if (brokenCnt == K) continue; // 더 못 부숨

                    if (moveCnt % 2 == 0) {
                        q.offer(new int[]{x, y, moveCnt + 1, brokenCnt});
                    } else {
                        int nb = brokenCnt + 1;
                        if (visit[nx][ny] != null && visit[nx][ny] <= nb) continue;
                        visit[nx][ny] = nb;
                        q.offer(new int[]{nx, ny, moveCnt + 1, nb});
                    }
                } else { // 빈 칸
                    if (visit[nx][ny] != null && visit[nx][ny] <= brokenCnt) continue;
                    visit[nx][ny] = brokenCnt;
                    q.offer(new int[]{nx, ny, moveCnt + 1, brokenCnt});
                }
            }
        }
    }
}
