import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] f = new long[n + 1];
        List<Integer> numbers = new ArrayList<>();

        f[0] = 1;

        for (int i = 1; i <= n; i++) {
            f[i] = f[i-1] * i;
            numbers.add(i);
        }

        k--;

        for (int i=0; i<n; i++) {
            long groupSize = f[n-1-i];
            int index = (int) (k / groupSize);

            answer[i] = numbers.remove(index);
            k %= groupSize;
        }

        return answer;
    }
}