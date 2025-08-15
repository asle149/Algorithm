import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char g = st.nextToken().charAt(0);
        HashSet<String> set = new HashSet<>();  
        
        for(int i=0; i<N; i++) set.add(br.readLine());
        
        int count = 0;
        if(g == 'Y') count = set.size();
        else if (g == 'F') count = set.size()/2;
        else if (g == 'O') count = set.size()/3;
        
        System.out.println(count);
    }
}