import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Cell {
        int x;
        int y;
        char type;
        int depth;

        public Cell(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.depth = 0;
        }
    }

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static Cell[][] cells;
    static int rows;
    static int cols;

    public int solution(String[] board) {
        rows = board.length;
        cols = board[0].length();

        return bfs(initCells(board));
    }

    private int bfs(Cell start) {
    	boolean[][] visited = new boolean[rows][cols];
    	
        Queue<Cell> q = new LinkedList<>();

        visited[start.x][start.y] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Cell curr = q.poll();

            if (curr.type == 'G') {
                return curr.depth;
            }

            for (int dir = 0; dir < 4; dir++) {
                Cell next = move(curr, dir);

                if (!visited[next.x][next.y]) {
                    visited[next.x][next.y] = true;
                    next.depth = curr.depth + 1;
                    q.add(next);
                }
            }
        }

        return -1;
    }

    private Cell move(Cell curr, int dir) {
        int nx = curr.x;
        int ny = curr.y;

        while (true) {
            int nextX = nx + dx[dir];
            int nextY = ny + dy[dir];

            if (!isInRange(nextX, nextY) || cells[nextX][nextY].type == 'D') {
                break;
            }

            nx = nextX;
            ny = nextY;
        }

        return cells[nx][ny];
    }

    private Cell initCells(String[] board) {
        cells = new Cell[rows][cols];

        Cell start = null;

        for (int i = 0; i < rows; i++) {
            String line = board[i];

            for (int j = 0; j < cols; j++) {
                char type = line.charAt(j);
                cells[i][j] = new Cell(i, j, type);

                if (type == 'R') {
                    start = cells[i][j];
                }
            }
        }

        return start;
    }

    private boolean isInRange(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
