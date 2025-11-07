import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] N = new int[n];
            int[] M = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                N[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                M[j] = Integer.parseInt(st.nextToken());
            }
            
            if (N.length > M.length) {
            	int[] temp = N;
                N = M;
                M = temp;
            }
            
            int max = Integer.MIN_VALUE;
            for (int i = 0; i <= M.length - N.length; i++) {
                int sum = 0;
                for (int j = 0; j < N.length; j++) {
                    sum += N[j] * M[i + j];
                }
                max = Math.max(max, sum);
            }

            sb.append("#").append(t).append(" ").append(max);
            if (t != T) {
            	sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}