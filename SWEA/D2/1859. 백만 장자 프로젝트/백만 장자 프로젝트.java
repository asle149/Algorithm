//package swea;
import java.io.*;
import java.util.*;

public class Solution {
	static int[] arr;
	
	public static void main(String args[]) throws IOException{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int Case = Integer.parseInt(br.readLine());
		for(int c=1; c<=Case; c++) {
			sb.append("#").append(c).append(" ");
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int num = arr[N-1];
			long ans = 0;
			
			for(int i=N-1; i>=0; i--) {
				if(arr[i]<num) {
					ans += num-arr[i];
				}else {
					num = arr[i];
				}
			}
			
			sb.append(ans).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
