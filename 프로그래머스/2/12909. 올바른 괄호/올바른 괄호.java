class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
            }else if(s.charAt(i) == ')'){
                if(cnt <= 0) return false;
                else cnt--;
            }
        }
        if(cnt == 0) return true;
        else return false;
    }
}