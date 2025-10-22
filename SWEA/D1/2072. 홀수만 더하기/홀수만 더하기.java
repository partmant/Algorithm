import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
        int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < 10; i++) {
				int n = Integer.parseInt(st.nextToken());
                
                if (n % 2 == 1) sum += n;
            }
            
            System.out.println("#" + test_case +" " + sum);
		}
	}
}