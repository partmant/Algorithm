import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());

            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            
            hour += Integer.parseInt(st.nextToken());
            minute += Integer.parseInt(st.nextToken());
            
			if (minute > 59) {
            	minute -= 60;
                hour++;
            }
            if (hour > 12) {
            	hour -= 12;
            }
		
            sb.append("#").append(t).append(" ").append(hour).append(" ").append(minute).append("\n");
        }
        
        sb.setLength(sb.length() -1);
        
        System.out.print(sb.toString());
    }
}