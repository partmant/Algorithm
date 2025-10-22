import java.util.*;

class Solution {
    static int[] dc = {1, 0, -1, 0};
    static int[] dr = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] array = new int[n][n];

            int r = 0, c = 0, d = 0;
            array[r][c] = 1;

            for (int i = 2; i <= n * n; i++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || array[nr][nc] != 0) {
                    d = (d + 1) % 4;
                    nr = r + dr[d];
                    nc = c + dc[d];
                }

                r = nr;
                c = nc;
                array[r][c] = i;
            }

            sb.append("#").append(test_case).append("\n");
            for (int[] row : array) {
                for (int column : row) {
                    sb.append(column).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}