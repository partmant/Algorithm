import java.io.*;
import java.util.*;

public class Solution {
    static boolean visited[];
    static int[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            board = new int[9][9];
            
            for (int i = 0; i < 9; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
            		board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
        	if(isBoxValid() && isColumnValid() && isRowValid()) {
            	sb.append("#").append(t).append(" ").append(1).append("\n");
        	} else {
            	sb.append("#").append(t).append(" ").append(0).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
	
    static boolean isBoxValid() {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                visited = new boolean[10];
                
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        int num = board[i][j];
                        if (visited[num]) return false;
                        visited[num] = true;
                    }
                }
            }
        }
        return true;
    }
    
    static boolean isRowValid() {
    	for (int i = 0; i < 9; i++) {
        	visited = new boolean[10];
            
            for (int j = 0; j < 9; j++) {
            	int num = board[i][j];
                if (visited[num]) {
                    return false;
                }
                visited[num] = true;
            }
        }
        
        return true;
    }
    
    static boolean isColumnValid() {
        for (int i = 0; i < 9; i++) {
            visited = new boolean[10];
            
            for (int j = 0; j < 9; j++) {
                int num = board[j][i];
                if (visited[num]) {
                    return false;
                }
                visited[num] = true;
            }
        }
        
        return true;
	}
}
