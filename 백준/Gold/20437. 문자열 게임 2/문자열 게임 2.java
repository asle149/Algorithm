import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String W = br.readLine().trim();
            int K = Integer.parseInt(br.readLine().trim());

            int bestMin = Integer.MAX_VALUE;
            int bestMax = -1;

            Deque<Integer>[] q = new ArrayDeque[26];

            for (int i=0; i<W.length(); i++) {
                char ch = W.charAt(i);
                int idx = ch - 'a';

                if (q[idx] == null) q[idx] = new ArrayDeque<>();
                q[idx].addLast(i);

                // 항상 최근 K개만 보유
                while (q[idx].size() > K) q[idx].pollFirst();

                // 정확히 K개가 창에 들어오면 길이 계산
                if (q[idx].size() == K) {
                    int len = i - q[idx].peekFirst() + 1;
                    if (len < bestMin) bestMin = len;
                    if (len > bestMax) bestMax = len;
                }
            }

            if (bestMax == -1) sb.append("-1\n");
            else sb.append(bestMin).append(' ').append(bestMax).append('\n');
        }
        System.out.print(sb); 
    }
}