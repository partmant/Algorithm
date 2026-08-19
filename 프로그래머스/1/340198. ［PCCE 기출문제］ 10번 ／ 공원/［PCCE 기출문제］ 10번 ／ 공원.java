import java.util.Arrays;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        int[][] dp = new int[rows + 1][cols + 1];
        int maxSquareSize = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (park[r][c].equals("-1")) {
                    dp[r + 1][c + 1] = Math.min(dp[r][c + 1], 
                                       Math.min(dp[r + 1][c], dp[r][c])) + 1;

                    maxSquareSize = Math.max(maxSquareSize, dp[r + 1][c + 1]);
                }
            }
        }

        Integer[] sortedMats = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedMats, (a, b) -> b - a);

        for (int size : sortedMats) {
            if (size <= maxSquareSize) {
                return size;
            }
        }

        return -1;
    }
}
