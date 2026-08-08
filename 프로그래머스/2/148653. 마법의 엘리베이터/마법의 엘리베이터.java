class Solution {
    public int solution(int st) {
        int ans = 0;
        while(st>0){
            if(st%10 > 5 || (st%10 == 5 && ((st/10)%10) >= 5)){
                ans += 10-(st%10);
                st = (st/10)+1;
            }else{
                ans += (st%10);
                st /= 10;
            }
        }

        return ans;
    }
}