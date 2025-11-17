//package swea;

import java.io.*;
import java.util.*;

class Solution{
	static int pr(char op) {
		if(op == '*') return 1;
		if(op == '+') return 2;
		return 0;
	}
	
	public static void main(String args[]) throws IOException {
      //System.setIn(new FileInputStream("input.txt"));
      StringBuilder ans = new StringBuilder();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int t=1; t<=10; t++) {
         StringBuilder sb = new StringBuilder();
         ans.append("#").append(t).append(" ");
         int len = Integer.parseInt(br.readLine());
         String str = br.readLine();
         Deque<Character> s = new ArrayDeque<>();
         for(int i=0; i<len; i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c)) {
               sb.append(c);
            }
            else {
            	while (!s.isEmpty() && pr(s.peek()) <= pr(c)) {
            	    sb.append(s.pop());
            	}
            	s.push(c);
            }
         }
         while(!s.isEmpty()) sb.append(s.pop());
         
         String post = sb.toString();
         Deque<Integer> num = new ArrayDeque<>();
         for(int i=0; i<post.length(); i++) {
            char c = post.charAt(i);
            if(Character.isDigit(c)) num.push(c - '0');
            else {
            	int a = num.pop();
            	int b = num.pop();
            	if(c == '+') num.push(a+b);
            	else num.push(a*b);
            }
         }
         
         ans.append(num.pop()).append("\n");                 
      }
      System.out.println(ans.toString());
   }
}