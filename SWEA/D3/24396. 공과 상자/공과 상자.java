import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());
            int max = Integer.MIN_VALUE;
            
            if (B > W) {
            	max = Math.max(Z * W * 2+ X * (B - W), max);	
            } else if (W > B) {
            	max = Math.max(Z * B * 2+ Y * (W - B), max);
            } else {
            	max = Math.max(Z * (B + W), max);
            }
            max = Math.max(B * X + W * Y, max);
            
            sb.append(max).append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        
        System.out.print(sb);
    }
}
