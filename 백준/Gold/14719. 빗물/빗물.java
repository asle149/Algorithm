import java.io.*;
import java.util.*;

public class Main{
    static int H, W;
    static int[] block;
    static int ans;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        block = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            block[i] = Integer.parseInt(st.nextToken());
        }
        
        ans = 0;
        for (int i=0; i<W-1; ) {
            if (block[i] == 0) {
                i++;
                continue;
            }

            int endB = -1;

            // 오른쪽에서 처음으로 block[i] 이상을 찾기
            for (int j=i+1; j<W; j++) {
                if (block[j] >= block[i]) {
                    endB = j;
                    break;
                }
            }
    
            // 못 찾았으면 i+1..W-1 중에서 최댓값 위치를 endB로
            if (endB == -1) {
                int maxIdx = i+1;
                for (int j=i+2; j<W; j++) {
                    if (block[j] > block[maxIdx]) maxIdx = j;
                }
                endB = maxIdx;
            }    
    
            int minHeight = Math.min(block[i], block[endB]);
    
            // i+1 ~ endB-1 구간 물 채우기
            for (int k=i+1; k<=endB-1; k++) {
                ans += Math.max(0, minHeight - block[k]);
            }
    
            // 다음 시작점은 endB (벽 유지)
            i = endB;
        }
                       
        System.out.println(ans);
    }
}