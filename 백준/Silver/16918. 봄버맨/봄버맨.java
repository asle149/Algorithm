import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if (N == 1) {
            printMap(map, sb);
        } else if (N % 2 == 0) {
            fillAndPrint('O', sb);
        } else {
            char[][] afterFirst = explode(map);
            if (N % 4 == 3) {
                printMap(afterFirst, sb);
            } else { // N % 4 == 1
                char[][] afterSecond = explode(afterFirst);
                printMap(afterSecond, sb);
            }
        }
    }

    static char[][] explode(char[][] input) {
        char[][] result = new char[R][C];
        boolean[][] toExplode = new boolean[R][C];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 폭발 대상 체크
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (input[i][j] == 'O') {
                    toExplode[i][j] = true;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            toExplode[nx][ny] = true;
                        }
                    }
                }
            }
        }

        // 결과 격자 채우기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[i][j] = toExplode[i][j] ? '.' : 'O';
            }
        }
        return result;
    }

    static void printMap(char[][] board, StringBuilder sb) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void fillAndPrint(char ch, StringBuilder sb) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(ch);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
