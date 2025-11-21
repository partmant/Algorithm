import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int max = 0;
            int sum = 0;
            
            for (int i = 0; i < 6; i++) {
                int now = Integer.parseInt(st.nextToken());
                max = Math.max(max, now);
                sum += now;
            }
            
            int remain = sum % 7;
            int result = 0;
            int index = 1;
            
            while (true) {
                if ((remain + max + index) % 7 == 0) {
                    result = max + index;
                    break;
                }
                index++;
            }
            
            sb.append (result).append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        
        System.out.print(sb);
    }
}
