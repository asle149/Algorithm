import java.io.*;
import java.util.*;

public class Main{
    static int n, w, L;
    static Queue<Integer> truck;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        truck = new LinkedList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            truck.offer(Integer.parseInt(st.nextToken()));
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<w; i++){
			q.add(0); //현재 다리에 올라와있는 트럭의 무게
		}
        
        int count = 0;
        int bridgeWeight = 0;
        while(!q.isEmpty()){
			count++;
			bridgeWeight-=q.poll();
			if(!truck.isEmpty()) {
				if(truck.peek()+bridgeWeight<=L) {
					bridgeWeight+=truck.peek();
					q.offer(truck.poll());
				}else {
					q.offer(0);
				}
			}
		}
		System.out.println(count);
    }
}