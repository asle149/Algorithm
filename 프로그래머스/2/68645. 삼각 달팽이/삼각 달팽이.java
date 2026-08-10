class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};

        int total = n * (n + 1) / 2;
        int x = -1;
        int y = 0;
        int direction = 0;

        for (int num = 1; num <= total; num++) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || nx >= n
                    || ny < 0 || ny >= n
                    || arr[nx][ny] != 0) {

                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
            arr[x][y] = num;
        }

        int[] answer = new int[total];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
}