import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
        	int N = sc.nextInt();
            int[][] P = new int[N][N];
            
            sb.append("#").append(t).append("\n");
            
            for (int r = 0; r < N; r++) {
            	for (int c = 0; c < r + 1; c++) {
                	if (c == 0 || c == r) {
                        P[r][c] = 1;
                    } else {
                        P[r][c] = P[r - 1][c] + P[r - 1][c - 1];
                    }
                    
                    sb.append(P[r][c]).append(" ");
                }
                
                sb.append("\n");
            }
        }
        
        System.out.print(sb.toString());
        sc.close();
    }
}