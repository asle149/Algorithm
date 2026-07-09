import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int start = 0; start < s.length(); start++) {
            if (check(s, start)) answer++;
        }

        return answer;
    }

    private boolean check(String s, int start) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt((start + i) % len);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char open = stack.peek();
                if (!isPair(open, c)) return false;

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private boolean isPair(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '{' && close == '}')
            || (open == '[' && close == ']');
    }
}