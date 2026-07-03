
class Solution {
    public int solution(int n) {
        int cnt1 = 0;
        cnt1 = Integer.bitCount(n);
        
        int ans = n;
        while(true){
            int cnt2 = 0; 
            ans++;
            cnt2 = Integer.bitCount(ans);
            if(cnt1 == cnt2) break;           
        }
        
        return ans;
    }
}