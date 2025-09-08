import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine()); 
            int count[] = new int[202]; 
            int teamNum[] = new int[N]; 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                int team = Integer.parseInt(st.nextToken());
                teamNum[i] = team;
                count[team]++; 
            }
            int score[] = new int[202]; 
            int passTeam[] = new int[202]; 
            int minscore = 1<<30, minteam = -1;
            
            int j=1;
            for (int i=0; i<N; i++){
                int team = teamNum[i]; 
                if (count[team] < 6) 
                    continue;
                passTeam[team]++;
                if (passTeam[team] <= 4)
                    score[team] += j << 19; 
                if (passTeam[team] == 5){
                    score[team] += j; 
                    if (score[team] < minscore){ 
                        minscore = score[team];
                        minteam = team;
                    }
                }
                j++;
            }
            System.out.println(minteam); 
        }
    }
}