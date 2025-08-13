import java.io.*;
import java.util.*;

public class Main{
    static String A, B;
    static char[] arrA, arrB;
    static int[][] dp;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        A = br.readLine(); B = br.readLine();
        arrA = A.toCharArray(); arrB = B.toCharArray();
        dp = new int[1001][1001];
        
        for(int i=1; i<=A.length(); i++){
            for(int j=1; j<=B.length(); j++){
                if(arrA[i-1] == arrB[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        int i=A.length(), j=B.length();
        while(i>0 && j>0){
            if(arrA[i-1] == arrB[j-1]){
                sb.append(arrA[i-1]);
                i--; j--;
            }else if(dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }
        
        System.out.println(dp[A.length()][B.length()]);
        System.out.println(sb.reverse());
    }
}