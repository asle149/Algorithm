import java.util.*;
import java.io.*;

public class Main {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static ArrayList<Integer> elevation = new ArrayList<>();	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(br.readLine());
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            elevation.add(temp);
        }
        int answer = Integer.MAX_VALUE;
        for(int i=min;i<max-17;i++)
            answer = Math.min(answer, cal(i, i+17));
        if(answer == Integer.MAX_VALUE)
            bw.write("0");
        else	
            bw.write(answer + "");
        bw.flush();		
        bw.close();
        br.close();
    }

    static int cal(int min, int max){
        int result = 0;
        for(int i=0;i<N;i++){
            int temp = 0;
            if(elevation.get(i) > max)
                temp = (int) Math.pow(elevation.get(i) - max ,2);
            else if(elevation.get(i) < min)
                temp = (int) Math.pow(min - elevation.get(i), 2);
            result += temp;
        }
        return result;
    }
}