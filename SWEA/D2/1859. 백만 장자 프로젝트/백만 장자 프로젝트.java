import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
            	nums[i] = Integer.parseInt(st.nextToken());		
            }    
            
            long result = 0;
            int max = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > max) {
                    max = nums[i];
                } else {
                    result += (max - nums[i]);
                }
            }
            
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
        
        System.out.print(sb);
	}
}