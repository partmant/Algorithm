import java.util.*;

class Solution {
    private static final int[] dr = {0, -1, 0, 1};
    private static final int[] dc = {1, 0, -1, 0};
    
    private int height, width;
    private boolean[][][] visited;

    public int[] solution(String[] grid) {
        height = grid.length;
        width = grid[0].length();
        visited = new boolean[height][width][4];
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                for (int d = 0; d < 4; d++) {
                    if (!visited[r][c][d]) {
                        answerList.add(getCycleLength(grid, r, c, d));
                    }
                }
            }
        }
        
        return answerList.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    private int getCycleLength(String[] grid, int r, int c, int d) {
        int length = 0;
        
        while (!visited[r][c][d]) {
            visited[r][c][d] = true;
            length++;
            
            char command = grid[r].charAt(c);
            if (command == 'L') {
                d = (d + 1) % 4;
            } else if (command == 'R') {
                d = (d + 3) % 4;
            }
            
            r = (r + dr[d] + height) % height;
            c = (c + dc[d] + width) % width;
        }
        
        return length;
    }
}