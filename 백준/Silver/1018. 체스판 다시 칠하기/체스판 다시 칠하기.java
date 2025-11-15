import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;
	static int min = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            board[i] = S.toCharArray();
        }
        
        for (int i = 0 ; i <= N - 8; i++) {
        	for (int j = 0 ; j <= M - 8; j++) {
        		check(i, j);
        	}
        }
        
        System.out.print(min);
    }
    
    static void check(int x, int y) {
    	char firstColor = board[x][y];
    	char secondColor = (firstColor == 'W' ? 'B' : 'W');
    	int count = 0;
    	
    	for (int i = x; i < x + 8; i++) {
    		for (int j = y; j < y + 8; j++) {
    			if (i % 2 == 0) {	// 짝수 행
    				if (j % 2 == 0) { // 짝수 열
    					if (board[i][j] != firstColor)
    						count++;
    				} else {	// 홀수 열
    					if (board[i][j] != secondColor)
    						count++;
    				}
    			} else {	// 홀수 행
    				if (j % 2 == 0) { // 짝수 열
    					if (board[i][j] != secondColor)
    						count++;
    				} else {	// 홀수 열
    					if (board[i][j] != firstColor)
    						count++;
    				}
    			}
    		}
    	}
    	
    	count = Math.min(count, 64 - count);
    	min = Math.min(min, count);
    }
}
