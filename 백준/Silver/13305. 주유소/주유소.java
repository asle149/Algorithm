import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        long[] price = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long ans = 0;
        long minPrice = price[0]; // 지금까지의 최저가

        for (int i=0; i<N-1; i++) {
            if (price[i] < minPrice) minPrice = price[i];
            ans += minPrice * dist[i]; // 최저가로 다음 구간 이동 비용 누적
        }

        System.out.println(ans);
    }
}