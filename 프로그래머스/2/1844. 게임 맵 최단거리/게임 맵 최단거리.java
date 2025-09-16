import java.util.*;

class Solution {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc] && maps[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        maps[nr][nc] = maps[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        int result = maps[n - 1][m - 1];
        return result == 1 ? -1 : result;
    }
}
