import java.util.*;
import java.io.*;

public class Main {
    
    static char[][] board;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = sc.nextInt();
        board = new char[N][N];
        
        draw(0, 0, N, false);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(board[i]).append('\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    static void draw(int x, int y, int n, boolean blank) {
        if (blank == true) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    board[i][j] = ' ';
                }
            }  
            return;
        }
        if (n == 1) {
            board[x][y] = '*';
            return;
        }
        
        int size = n / 3;
        int count = 0;
        
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count++;
                if (count == 5) {
                    draw(i, j, size, true);
                } else {
                    draw(i, j, size, false);
                }
            }
        }
    }
}