import java.util.*;

class Solution {
    static class Node {
        String w;
        int d;

        Node(String w, int d) {
            this.w = w;
            this.d = d;
        }
    }

    public int solution(String begin, String target, String[] words) {
        boolean check = false;
        for (String s : words) {
            if (s.equals(target)) check = true;
        }
        if (!check) return 0;

        Queue<Node> q = new LinkedList<>();
        boolean[] v = new boolean[words.length];

        q.offer(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.w.equals(target)) return cur.d;

            for (int i = 0; i < words.length; i++) {
                if (!v[i] && diff(cur.w, words[i])) {
                    v[i] = true;
                    q.offer(new Node(words[i], cur.d + 1));
                }
            }
        }
        return 0;
    }

    static boolean diff(String a, String b) {
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) c++;
        }
        return c == 1;
    }
}