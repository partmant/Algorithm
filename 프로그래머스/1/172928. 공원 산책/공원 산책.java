class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();
        int[][] prefixSum = new int[H + 1][W + 1];
        int curR = 0, curC = 0;

        for (int r = 1; r <= H; r++) {
            for (int c = 1; c <= W; c++) {
                char cell = park[r - 1].charAt(c - 1);
                int isObstacle = (cell == 'X') ? 1 : 0;

                prefixSum[r][c] = prefixSum[r - 1][c] + prefixSum[r][c - 1]
                                - prefixSum[r - 1][c - 1] + isObstacle;

                if (cell == 'S') {
                    curR = r;
                    curC = c;
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            int dirIdx = getDirIndex(parts[0]);
            int step = Integer.parseInt(parts[1]);

            int nextR = curR + dr[dirIdx] * step;
            int nextC = curC + dc[dirIdx] * step;

            if (nextR < 1 || nextR > H || nextC < 1 || nextC > W) {
                continue;
            }

            if (isBlocked(prefixSum, curR, curC, nextR, nextC)) {
                continue;
            }

            curR = nextR;
            curC = nextC;
        }

        return new int[]{curR - 1, curC - 1};
    }

    private int getDirIndex(String dir) {
        switch (dir) {
            case "N": return 0;
            case "S": return 1;
            case "W": return 2;
            case "E": return 3;
            default: return -1;
        }
    }

    private boolean isBlocked(int[][] pSum, int r1, int c1, int r2, int c2) {
        int minR = Math.min(r1, r2);
        int maxR = Math.max(r1, r2);
        int minC = Math.min(c1, c2);
        int maxC = Math.max(c1, c2);

        int count = pSum[maxR][maxC] - pSum[minR - 1][maxC] 
                  - pSum[maxR][minC - 1] + pSum[minR - 1][minC - 1];

        return count > 0;
    }
}
