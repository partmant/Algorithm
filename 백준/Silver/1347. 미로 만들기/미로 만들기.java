import java.util.*;

public class Main {
    static final int[][] direction = {
        {1, 0},
        {0, -1},
        {-1, 0},
        {0, 1}
    };
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Location> q = new LinkedList<>();
        
        int n = sc.nextInt();
        
        String s = sc.next();
        
        Location now = new Location(0, 0, 0);
        q.add(now);

        int minRow = 0;
        int maxRow = 0;
        int minCol = 0;
        int maxCol = 0;
        
        for (int i = 0; i < n; i++) {
            char token = s.charAt(i);
            
            if (token == 'R') {
                int nextDir = (++now.dir) % 4;
                now = new Location(now.row, now.col, nextDir);
            } else if (token == 'L') {
                int nextDir = (--now.dir + 4) % 4;
                now = new Location(now.row, now.col, nextDir);
            } else if (token == 'F') {
                int nextRow = now.row + direction[now.dir][0];
                int nextCol = now.col + direction[now.dir][1];
                
                now = new Location(nextRow, nextCol, now.dir);
                    
                minRow = Math.min(minRow, nextRow);
                maxRow = Math.max(maxRow, nextRow);
                minCol = Math.min(minCol, nextCol);
                maxCol = Math.max(maxCol, nextCol);
            }
            
            q.add(now);
        }
        
        int rowSize = maxRow - minRow + 1;
        int colSize = maxCol - minCol + 1;
        
        boolean[][] board = new boolean[rowSize][colSize];
        
        while (!q.isEmpty()) {
            now = q.poll();
            board[now.row - minRow ][now.col - minCol] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (boolean[] r : board) {
            for (boolean c : r) {
                sb.append(c ? "." : "#");
            }
            sb.append("\n");
        }
        
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}

class Location {
    int row;
    int col;
    int dir;
        
    Location(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.dir = d;
    }
}