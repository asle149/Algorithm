import java.io.*;
import java.util.*;

class Solution {
    static LinkedList<String> list;
    static boolean[] visited;
    static String[][] tickets;
    
    public String[] solution(String[][] tickets) {
        Solution.tickets = tickets;
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        list = new LinkedList<>();
        visited = new boolean[tickets.length];
        list.add("ICN");
        dfs("ICN");
        
        String[] ans = new String[tickets.length+1];
        for(int i=0; i<tickets.length+1; i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
    
    public boolean dfs(String Depart){
        if(list.size() == tickets.length+1) return true;
        
        for(int i=0; i<tickets.length; i++){
            if(visited[i]) continue;
            if(tickets[i][0].equals(Depart)){
                visited[i] = true;
                list.add(tickets[i][1]);
                if(dfs(tickets[i][1])) return true;
                visited[i] = false;
                list.removeLast();
            }
        }        
        
        return false;
    }
}