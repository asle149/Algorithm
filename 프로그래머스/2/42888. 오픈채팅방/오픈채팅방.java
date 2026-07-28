import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        String[][] pr = new String[record.length][2];
        ArrayList<String> l = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
            String[] arr = record[i].split(" ");
            pr[i][0] = arr[0];
            pr[i][1] = arr[1];
            if(!arr[0].equals("Leave")) map.put(arr[1], arr[2]);
        }
        
        
        
        for(int i=0; i<record.length; i++){
            String work = pr[i][0];
            String id = pr[i][1];
            String nn = map.get(pr[i][1]);
            StringBuilder sb = new StringBuilder();
            
            if(work.equals("Change")) continue;
            else if(work.equals("Enter")){
                sb.append(nn).append("님이 들어왔습니다.");
            }else{
                sb.append(nn).append("님이 나갔습니다.");
            }
            
            l.add(sb.toString());
        }
        
        String[] ans = l.toArray(new String[0]);
        
        return ans;
    }
    
}