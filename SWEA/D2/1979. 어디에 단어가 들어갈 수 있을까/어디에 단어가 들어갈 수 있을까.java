import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] board;
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int result = 0;
            board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < N; j++) {
                	board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for (int r = 0; r < N; r++) {
                int length = 0;
				for (int c = 0; c < N; c++) {
                	if (board[r][c] == 1) {
                    	length++;
                    } else {
                        if (length == K) {
                        	result++;
                        }
                        length = 0;
                    }
                }
                if (length == K) {
                	result++;
                }
            }
            
            for (int c = 0; c < N; c++) {
                int length  = 0;
            	for (int r = 0; r < N; r++) {
             		if (board[r][c] == 1) {
                        length++;
                    } else {
                    	if (length == K) {
                        	result++;
                        }
                        length = 0;
                    }
                }
                if (length == K) {
                	result++;
                }
           	}
            
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
    
        System.out.print(sb.toString());
    } 
}