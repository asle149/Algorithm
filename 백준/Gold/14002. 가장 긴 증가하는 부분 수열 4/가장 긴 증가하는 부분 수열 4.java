import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1]; // 수열 추적을 위한 배열
        Arrays.fill(prev, -1); // 초기값: -1 (이전 위치가 없음을 의미)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        int maxIndex = 0; // 가장 긴 수열의 마지막 인덱스

        for (int i = 1; i <= N; i++) {
            dp[i] = 1; // 초기 길이는 자기 자신만 포함
            for (int j = 1; j < i; j++) {
                if (A[j] < A[i]) { // 증가 조건
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j; // 이전 인덱스를 저장
                    }
                }
            }
            if (dp[i] > maxLength) { // 최댓값 갱신
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        // 수열 복원
        List<Integer> sequence = new ArrayList<>();
        while (maxIndex != -1) {
            sequence.add(A[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        Collections.reverse(sequence); // 역순으로 저장했으므로 뒤집기

        // 결과 출력
        System.out.println(maxLength); // 가장 긴 수열의 길이 출력
        for (int num : sequence) {
            System.out.print(num + " "); // 가장 긴 증가 부분 수열 출력
        }
    }
}
