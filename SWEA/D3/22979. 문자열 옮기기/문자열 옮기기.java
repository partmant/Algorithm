import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	Deque<Character> dq = new ArrayDeque<>();
            
            char[] words = br.readLine().toCharArray();
            for (char word : words) {
            	dq.add(word);
            }
            
            int commandCnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < commandCnt; i++) {
            	int command = Integer.parseInt(st.nextToken());
                
                if (command > 0) {
                	command %= words.length;
                    while (command-- > 0) {
                    	dq.add(dq.poll());
                    }
                } else if (command < 0) {
                    command %= words.length;
                	while (command++ < 0) {
                    	dq.addFirst(dq.pollLast());
                    }
                }                    
            }
            
            for (char word : dq) {
	            sb.append(word);
            }
            sb.append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        
        System.out.print(sb);
    }
}
