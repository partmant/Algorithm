import java.util.*;

class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            String s = sc.next();
        	char[] commands = s.toCharArray();
            
            int qCount = 0;
            int maxDist = 0;
            int position = 0;
            
            for (char command : commands) {
                if (command == '?') {
                    qCount++;
                } else if (command == 'R') {
                	position++;
                } else if (command == 'L') {
                    position--;
                }
                
                int minPos = position - qCount;
                int maxPos = position + qCount;

                maxDist = Math.max(maxDist, Math.abs(minPos));
                maxDist = Math.max(maxDist, Math.abs(maxPos));
            }
            
            sb.append(maxDist).append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        
        System.out.print(sb);
    }
}
