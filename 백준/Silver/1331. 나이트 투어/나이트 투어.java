import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] visited = new boolean[6][6];
        int[] now = new int[2];
        int startR = -1, startC = -1;
        boolean result = true;

        for (int i = 0; i < 36; i++) {
            String s = sc.next();
            int r = s.charAt(0) - 'A';
            int c = s.charAt(1) - '1'; 

            if (i == 0) {
                startR = r;
                startC = c;
                visited[r][c] = true;
                now[0] = r;
                now[1] = c;
                continue;
            }

            if (isKnightMove(now[0], now[1], r, c)) {
                if (visited[r][c] == false) {
                    visited[r][c] = true;
                    now[0] = r;
                    now[1] = c;
                } else {
                    result = false;
                    break;
                }
            } else {
                result = false;
                break;
            }
        }
        
        if (result == true) {
            if (!isAllVisited(visited) || !isKnightMove(now[0], now[1], startR, startC)) {
                result = false;
            }
        }
        
        System.out.print(result ? "Valid" : "Invalid");
    }
    
    private static boolean isKnightMove(int r1, int c1, int r2, int c2) {
        int dr = Math.abs(r1 - r2);
        int dc = Math.abs(c1 - c2);
        
        return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
    }
    
    private static boolean isAllVisited(boolean[][] visited) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}