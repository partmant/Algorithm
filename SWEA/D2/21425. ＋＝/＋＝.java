import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int count = 0;
            
            while (x <= n && y <= n) {
            	if (x > y) {
                    y += x;
                } else {
                    x += y;
                }
                count++;
            }
            
            if (test_case == T) {
            	bw.write(String.valueOf(count));
            } else {
            	bw.write(String.valueOf(count));
                bw.newLine();
            }
        }
        
        bw.flush();
	}
}
