import java.util.*;

class Solution {
    public String solution(String[] p, String[] c) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<c.length; i++) {
            if(map.containsKey(c[i])) map.put(c[i], map.get(c[i])+1);
            else map.put(c[i], 0);
        }
        
        String answer = "";
        for(String str : p){
            if(!map.containsKey(str)){
                answer = str;
                break;
            }else if(map.get(str)<0){
                answer = str;
                break;
            }else{
                map.put(str, map.get(str)-1);
            }
        }
        return answer;
    }
}