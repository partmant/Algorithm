import java. io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            
            int sum = 0;
            for (int i = 0; i < 10; i++) {
            	sum += Integer.parseInt(st.nextToken());
            }
            
            int avg = Math.round((float)sum / 10);
            sb.append("#").append(t).append(" ").append(avg).append("\n");
        }
        
        sb.setLength(sb.length() -1);
        
        System.out.print(sb.toString());
    }
}