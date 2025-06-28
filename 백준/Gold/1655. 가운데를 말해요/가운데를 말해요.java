import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if(maxHeap.size()<minHeap.size()){
                maxHeap.offer(minHeap.poll());
            }
            System.out.println(maxHeap.peek());
        }
    }
}