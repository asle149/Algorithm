class Solution {
    public long solution(int a, int b) {
        return (long) ((a + b) / 2.0 * ((a > b) ? a - b + 1 : b - a + 1));
    }
}