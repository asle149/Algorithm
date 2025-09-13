import java.io.*;
import java.util.*;

public class Main{
    static char[] info;
    static int ans = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        info = br.readLine().toCharArray();	

        for(int i=0;i<N;i++){
            if(info[i] == 'P'){		
                int index = Math.max(i - K, 0);
                boolean check = false;
                
                for(int j=index;j<i;j++){
                    if(bergerCheck(j)){	
                        check = true;
                        break;
                    }
                }

                if(!check){
                    index = i + K >= N ? N-1 : i + K;
                    for(int j=i+1;j<=index;j++){
                        if(bergerCheck(j))	
                            break;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static boolean bergerCheck(int index){
        if(info[index] == 'H'){		
            info[index] = 'X';
            ans++;	
            return true;	
        }
        return false;		
    }
}