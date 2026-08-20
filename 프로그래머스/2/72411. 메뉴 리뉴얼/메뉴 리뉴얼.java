import java.util.*;

class Solution {
    private Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int size : course) {
            map = new HashMap<>();

            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);

                find(arr, 0, size, new StringBuilder());
            }

            int maxCount = 0;

            for (int count : map.values()) {
                maxCount = Math.max(maxCount, count);
            }

            if (maxCount < 2) {
                continue;
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    answer.add(entry.getKey());
                }
            }
        }

        Collections.sort(answer);       
        return answer.toArray(new String[0]);
    }

    private void find(char[] arr, int start, int target,
                      StringBuilder selected) {
        if (selected.length() == target) {
            String combination = selected.toString();

            map.put(
                combination,
                map.getOrDefault(combination, 0) + 1
            );
            return;
        }

        for (int i = start; i < arr.length; i++) {
            selected.append(arr[i]);
            find(arr, i + 1, target, selected);
            selected.deleteCharAt(selected.length() - 1);
        }
    }
}