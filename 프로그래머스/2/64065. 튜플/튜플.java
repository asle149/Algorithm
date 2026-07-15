import java.util.*;

class Solution {
    public int[] solution(String s) {
        String str = s.substring(2, s.length()-2);
        String[] arr = str.split("\\},\\{");
        Arrays.sort(arr, (a, b) -> a.length()-b.length());
        
        int[] ans = new int[arr.length];
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<arr.length; i++){
            String[] numbers = arr[i].split(",");
            for(String num : numbers){
                int n = Integer.parseInt(num);
                if(set.add(n)){
                    ans[i] = n;
                }
            }
        }
        
        return ans;
    }
}