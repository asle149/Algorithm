import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[R][C];
		for(int i =0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j< C; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		for(int n = 0; n< N ;n++) {
			st = new StringTokenizer(br.readLine());
			int R_s = Integer.parseInt(st.nextToken())-1;
			int C_s = Integer.parseInt(st.nextToken())-1;
			int D_s = Integer.parseInt(st.nextToken());
			int max = 0; 
			for(int i =R_s; i< R_s+3; i++) {
				for(int j = C_s; j< C_s+3; j++) {
					max = arr[i][j]>max?arr[i][j]:max;
				}
			}
			max-=D_s;
			for(int i =R_s; i< R_s+3; i++) {
				for(int j = C_s; j< C_s+3; j++) {
					arr[i][j] = arr[i][j]>max?max:arr[i][j];
				}
			}
		}
		int depth = 0; 
		for(int i =0; i< R; i++) {
			for(int j =0; j< C ; j++) {
				if(arr[i][j]<E) depth+=E-arr[i][j];
			}
		}
		System.out.println(depth*72*72);
	}
}