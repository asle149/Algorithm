import java.io.*;
import java.util.*;

public class Main {
    static int N, D;
    static List<int[]>[] shortcuts; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortcuts = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            shortcuts[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (s < 0 || s > D) {
                continue;
            }
            if (e > D) {
                continue;
            }
            if (w >= e - s) {
                continue;
            }
            shortcuts[s].add(new int[] {e, w});
        }

        final int INF = 1_000_000_000;
        int[] dist = new int[D + 1];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int i = 0; i < D; i++) {
            if (dist[i] + 1 < dist[i + 1]) {
                dist[i + 1] = dist[i] + 1;
            }
            for (int[] edge : shortcuts[i]) {
                int e = edge[0];
                int w = edge[1];
                if (dist[i] + w < dist[e]) {
                    dist[e] = dist[i] + w;
                }
            }
        }
        System.out.println(dist[D]);
    }
}