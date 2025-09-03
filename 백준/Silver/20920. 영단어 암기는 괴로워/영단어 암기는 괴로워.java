import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            String w = br.readLine();
            if (w.length() >= M) {
                map.merge(w, 1, Integer::sum);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());
        Collections.sort(words, (a, b) -> {
            int fComp = Integer.compare(map.get(b), map.get(a)); 
            if (fComp != 0) return fComp;
            int lenComp = Integer.compare(b.length(), a.length());  
            if (lenComp != 0) return lenComp;
            return a.compareTo(b);                               
        });

        for (String w : words) sb.append(w).append('\n');
        System.out.print(sb);
    }
}