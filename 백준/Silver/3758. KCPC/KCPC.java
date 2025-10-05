import java.util.*;
import java.io.*;
 
public class Main {
    static int T, n, k, t, m;
    static int[][] logs;   
    static List<Info> list; 
    static StringBuilder sb = new StringBuilder();
 
    static class Info implements Comparable<Info> {
        int id, score, cnt, time;
 
        public Info(int id, int score, int cnt, int time) {
            this.id = id;     
            this.score = score; 
            this.cnt = cnt;    
            this.time = time;
        }
 
        @Override
        public int compareTo(Info i) {
            if (this.score == i.score) {    
                if (this.cnt == i.cnt)     
                    return this.time - i.time;
                return this.cnt - i.cnt;  
            }
            return i.score - this.score;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());  
            k = Integer.parseInt(st.nextToken());   
            t = Integer.parseInt(st.nextToken());   
            m = Integer.parseInt(st.nextToken());  
 
            logs = new int[m][3];
 
            for (int x = 0 ; x < m ; x++) {
                st = new StringTokenizer(br.readLine(), " ");
                int i = Integer.parseInt(st.nextToken()); 
                int j = Integer.parseInt(st.nextToken());   
                int s = Integer.parseInt(st.nextToken());  

                logs[x][0] = i;
                logs[x][1] = j;
                logs[x][2] = s;
            }
 
            int[][] saveScore = new int[n+1][k+1]; 
            int[] cntSubmit = new int[n+1]; 
            int[] time = new int[n+1]; 
 
            for (int i = 0 ; i < m ; i++) {
                int nowId = logs[i][0];
                int nowNum = logs[i][1];
                int nowScore = logs[i][2];
 
                cntSubmit[nowId]++;
                time[nowId] = i;
 
                if (nowScore > saveScore[nowId][nowNum]) {
                    saveScore[nowId][nowNum] = nowScore;
                }
            }
 
            list = new ArrayList<>();   
            for (int i = 1 ; i <= n ; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    sum += saveScore[i][j];
                }

                list.add(new Info(i, sum, cntSubmit[i], time[i]));
            }
 
            Collections.sort(list); 

            for (int i = 0 ; i < n ; i++) {
                if (list.get(i).id == t) {
                    sb.append((i + 1) + "\n");
                }
            }
        }
 
        System.out.println(sb.toString());
    }
}