import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] room = new char[n][n];

        for (int i = 0; i < n; i++) {
            room[i] = br.readLine().toCharArray();
        }

        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) horizontal++;
                    count = 0;
                }
            }
            if (count >= 2) horizontal++;
        }

        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) vertical++;
                    count = 0;
                }
            }
            if (count >= 2) vertical++;
        }

        System.out.println(horizontal + " " + vertical);
    }
}
