import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ans = new int[N+1];
		for(int i=1; i<= N; i++) {
			int count = Integer.parseInt(st.nextToken());
			for(int j=1; j<=N; j++) {
				if(count==0) {
					if(ans[j]==0) {
						ans[j]=i; 
						break;
					}
					else continue;
				}
				else if(ans[j]==0) {
					count--;
				}
			}
		}
        
		for(int i=1; i<=N; i++) { System.out.print(ans[i]+" "); }
	}
}