import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private final int[] dr = {0, 1, 0, -1};
    private final int[] dc = {1, 0, -1, 0};

    private boolean[][] visited;
    private int row;
    private int col;

    public int[] solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();

        visited = new boolean[row][col];

        ArrayList<Integer> result = new ArrayList<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (!visited[r][c] && maps[r].charAt(c) != 'X') {
                    result.add(bfs(maps, r, c));
                }
            }
        }

        if (result.isEmpty()) {
            return new int[] {-1};
        }

        Collections.sort(result);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int bfs(String[] maps, int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {startR, startC});
        visited[startR][startC] = true;

        int sum = maps[startR].charAt(startC) - '0';

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nextR = r + dr[d];
                int nextC = c + dc[d];

                if (nextR < 0 || nextR >= row || nextC < 0 || nextC >= col) {
                    continue;
                }

                if (visited[nextR][nextC]) {
                    continue;
                }

                if (maps[nextR].charAt(nextC) == 'X') {
                    continue;
                }

                visited[nextR][nextC] = true;
                queue.add(new int[] {nextR, nextC});
                sum += maps[nextR].charAt(nextC) - '0';
            }
        }

        return sum;
    }
}
