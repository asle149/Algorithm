import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); 
        int n = s.length();

        int ans = 0;
        for (int start = 0; start < n; start++) {
            ans = Math.max(ans, prefixMaxOnSuffix(s, start));
        }
        System.out.println(ans);
    }

    private static int prefixMaxOnSuffix(String s, int start) {
        int len = s.length() - start;
        if (len <= 1) {
            return 0;
        }

        int[] pi = new int[len];
        int j = 0;
        int localMax = 0;

        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(start + i) != s.charAt(start + j)) {
                j = pi[j - 1];
            }
            if (s.charAt(start + i) == s.charAt(start + j)) {
                pi[i] = ++j;
                if (pi[i] > localMax) {
                    localMax = pi[i];
                }
            }
        }
        return localMax;
    }
}