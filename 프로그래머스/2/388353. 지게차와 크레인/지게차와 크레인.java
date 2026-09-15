import java.util.*;

class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    
    private int row, col;
    
    public int solution(String[] storage, String[] requests) {
        row = storage.length;
        col = storage[0].length();
        int totalCount = row * col;

        char[][] map = new char[row][col];
        for (int r = 0; r < row; r++) {
            map[r] = storage[r].toCharArray();
        }

        for (String req : requests) {
            char target = req.charAt(0);

            if (req.length() == 2) {
                totalCount -= removeWithCrane(map, target);
            } else {
                totalCount -= removeWithForklift(map, target);
            }
        }

        return totalCount;
    }

    private int removeWithForklift(char[][] map, char target) {
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> toRemove = new ArrayList<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0 || r == row - 1 || c == 0 || c == col - 1) {
                    if (map[r][c] == '.' && !visited[r][c]) {
                        visited[r][c] = true;
                        q.add(new int[]{r, c});
                    } else if (map[r][c] == target && !visited[r][c]) {
                        visited[r][c] = true;
                        toRemove.add(new int[]{r, c});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && !visited[nr][nc]) {
                    if (map[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    } else if (map[nr][nc] == target) {
                        visited[nr][nc] = true;
                        toRemove.add(new int[]{nr, nc});
                    }
                }
            }
        }

        for (int[] pos : toRemove) {
            map[pos[0]][pos[1]] = '.';
        }

        return toRemove.size();
    }

    private int removeWithCrane(char[][] map, char target) {
        int removedCount = 0;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r][c] == target) {
                    map[r][c] = '.';
                    removedCount++;
                }
            }
        }

        return removedCount;
    }
}