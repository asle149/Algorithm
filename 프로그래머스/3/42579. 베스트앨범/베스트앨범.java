import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ansList = new ArrayList<>();
        
        HashMap<String, Integer> gMap = new HashMap<>();
        Map<String, List<Integer>> music = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            gMap.put(genres[i], gMap.getOrDefault(genres[i], 0)+plays[i]);
            if (!music.containsKey(genres[i])) music.put(genres[i], new ArrayList<>());
            music.get(genres[i]).add(i);   
        }
        List<String> gen = new ArrayList<>(gMap.keySet());
        gen.sort((o1, o2) -> gMap.get(o2).compareTo(gMap.get(o1)));
        
        for(String g : gen){
            List<Integer> l = music.get(g);
            Collections.sort(l, (a, b) -> {
                if (plays[a] != plays[b]) return Integer.compare(plays[b], plays[a]);
                return Integer.compare(a, b); });
            ansList.add(l.get(0));
            if(l.size()>=2) ansList.add(l.get(1));
        }
        
        int[] ans = new int[ansList.size()];
        for(int i=0; i<ansList.size(); i++){
            ans[i] = ansList.get(i);
        }
        
        return ans;
    }
}