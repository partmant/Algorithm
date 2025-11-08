import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	int n = Integer.parseInt(br.readLine());
            int lineLength = 0;
            
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
            	char ch = st.nextToken().charAt(0);
                int count = Integer.parseInt(st.nextToken());
                
                while (count-- > 0) {
                	if (lineLength == 10) {
						lineLength = 0;
                        sb.append("\n");
                    }
                    sb.append(ch);
                    lineLength++;
                }
            }
            
            sb.append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}
