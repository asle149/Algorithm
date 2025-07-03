import java.io.*;
import java.util.*;

public class Main{
    static long DIV = 1000;
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long[][] A = new long[N][N];
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        long[][] result = pow(A, B);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static long[][] multi(long[][] A, long[][] B){
        long[][] result = new long[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    result[i][j] += (A[i][k]*B[k][j])%DIV;
                }
                result[i][j] %= DIV;
            }
        }
        return result;
    }
    
    static long[][] pow(long[][] A, long B){
        if(B == 1) {
            long[][] base = new long[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    base[i][j] = A[i][j] % DIV;
                }
            }
            return base;
        }
        long[][] half = new long[N][N];
        half = pow(A, B/2);
        
        if(B%2 == 0) return multi(half, half);
        else return multi(multi(half, half), A);
    }
}