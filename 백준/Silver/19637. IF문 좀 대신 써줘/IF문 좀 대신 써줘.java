import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
        
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        String[] title = new String[N];
        int[] limit = new int[N]; // 전투력 상한 (비내림차순으로 주어짐)
        
        for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			title[i] = st.nextToken();
			limit[i] = Integer.parseInt(st.nextToken());
		}
        
        for (int i = 0; i < M; i++) {
            int p = Integer.parseInt(br.readLine()); 
            int idx = lowerBound(limit, p);
            sb.append(title[idx]).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static int lowerBound(int[] a, int key) {
        int lo = 0, hi = a.length - 1, ans = a.length;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (a[mid] >= key) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}