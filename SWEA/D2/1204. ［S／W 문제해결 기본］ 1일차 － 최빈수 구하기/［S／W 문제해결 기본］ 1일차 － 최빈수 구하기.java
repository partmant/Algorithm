import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++) {
        	int testNum = Integer.parseInt(br.readLine());
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] freq = new int[101];
            for (int i = 0; i < 1000; i++) {
                freq[Integer.parseInt(st.nextToken())]++;
            }
            
			int result = 0;
            for (int score = 100; score >= 0; score--) {
                if (freq[score] > freq[result]) {
                    result = score;
                }
            }
            
            System.out.println("#" + testNum + " " + result);
        }
	}
}