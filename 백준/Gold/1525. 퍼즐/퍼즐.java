import java.io.*;
import java.util.*;

public class Main {
    static String swap(String str, int a, int b) {
        char[] arr = str.toCharArray();
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return new String(arr);
    }

    static String start;
    static final String GOAL = "123456780";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(9);
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append(st.nextToken()).append(st.nextToken());
        }
        start = sb.toString();
        System.out.println(bfsString());
    }

    static int bfsString() {
        if (start.equals(GOAL)) {
            return 0;
        }
        ArrayDeque<String> q = new ArrayDeque<>();
        HashMap<String, Integer> dist = new HashMap<>(400000);
        dist.put(start, 0);
        q.offer(start);
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            String cur = q.poll();
            int d = dist.get(cur);
            int zero = cur.indexOf('0');
            int r = zero / 3;
            int c = zero % 3;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= 3 || nc < 0 || nc >= 3) {
                    continue;
                }
                int nextIdx = nr * 3 + nc;
                String nxt = swap(cur, zero, nextIdx);

                if (dist.containsKey(nxt)) {
                    continue;
                }
                int nd = d + 1;
                if (nxt.equals(GOAL)) {
                    return nd;
                }
                dist.put(nxt, nd);
                q.offer(nxt);
            }
        }
        return -1;
    }
}