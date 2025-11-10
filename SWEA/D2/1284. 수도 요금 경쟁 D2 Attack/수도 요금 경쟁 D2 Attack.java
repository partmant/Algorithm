import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    
        int T = Integer.parseInt(br.readLine());
		
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int feeA = Integer.parseInt(st.nextToken());
            int baseFeeB = Integer.parseInt(st.nextToken());
        	int usageLimit = Integer.parseInt(st.nextToken());
            int feeB = Integer.parseInt(st.nextToken());
            int usage = Integer.parseInt(st.nextToken());
                
            int min = feeA * usage;
            if (usage > usageLimit) {
            	min = Math.min(min, baseFeeB + (usage - usageLimit) * feeB); 
            } else {
            	min = Math.min(min, baseFeeB);
            }
            
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }	
}