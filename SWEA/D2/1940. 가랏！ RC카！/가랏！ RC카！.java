import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
    	int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	int n = Integer.parseInt(br.readLine());
            int acceleration = 0;
            int distance = 0;
            
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
            	int command = Integer.parseInt(st.nextToken());
                
                int value = 0;
                if (st.hasMoreTokens()) {
                    value = Integer.parseInt(st.nextToken());
                }
                
                if (command == 1) {
                	acceleration += value;
               	} else if (command == 2) {
                    acceleration = Math.max(0, acceleration - value);                   
                }
                
                distance += acceleration;
            }
            
            sb.append("#").append(t).append(" ").append(distance);
            if (t != T) {
            	sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}