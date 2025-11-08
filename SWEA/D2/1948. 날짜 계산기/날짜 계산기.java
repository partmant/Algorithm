import java.util.*;
import java.io.*;

public class Solution {
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int month1 = Integer.parseInt(st.nextToken());
            int day1 = Integer.parseInt(st.nextToken());
            int month2 = Integer.parseInt(st.nextToken());
            int day2 = Integer.parseInt(st.nextToken());

            int result = 0;
            if (month1 == month2) {
            	result = day2 - day1 + 1;
            } else {
                for (int i = month1 + 1; i < month2; i++) {
                	result += days[i];
                }
                result += days[month1] - day1 + day2 + 1;
            }
            
            sb.append("#").append(t).append(" ").append(result);
            if (t != T) {
                sb.append("\n");
            } 
        }
        
        System.out.print(sb);
    }
}