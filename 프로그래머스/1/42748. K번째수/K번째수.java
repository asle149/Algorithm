import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> ans = new ArrayList<>();
        
        for(int x=0; x<commands.length; x++){
            List<Integer> list = new ArrayList<>();
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            for(int y=i-1; y<=j-1; y++){
                list.add(array[y]);
            }
            Collections.sort(list);
            ans.add(list.get(k-1));
        }
        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}