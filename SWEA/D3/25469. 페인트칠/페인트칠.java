import java.io.*;
import java.util.*;

public class Solution {
    static char[][] board;
    static boolean[][] visited;
    static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            board = new char[row][col];
            for (int i = 0; i < row; i++) {
                board[i] = br.readLine().toCharArray();
            }

            visited = new boolean[row][col];
            count = 0;

            if (row >= col) {
            	checkCol(row, col);
                checkRow(row, col);
            } else {
                checkRow(row, col);
                checkCol(row, col);
            }

            sb.append(count).append('\n');
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
    
    static void checkRow(int row, int col) {
    	for (int i = 0; i < row; i++) {
        	boolean full = true;
           	boolean drowable = false;
            
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') {
                    full = false;
                    break;
                }
                if (visited[i][j] == false) {
                	drowable = true;
                }
            }
            
            if (full && drowable) {
                for (int j = 0; j < col; j++) {
                    visited[i][j] = true;
                }
                count++;
            }
        }
    }
    
    static void checkCol(int row, int col) {
    	for (int i = 0; i < col; i++) {
        	boolean full = true;
           	boolean drowable = false;
            
            for (int j = 0; j < row; j++) {
                if (board[j][i] == '.') {
                    full = false;
                    break;
                }
                if (visited[j][i] == false) {
                	drowable = true;
                }
            }
            
            if (full && drowable) {
                for (int j = 0; j < row; j++) {
                    visited[j][i] = true;
                }
                count++;
            }
        }
    }
}
