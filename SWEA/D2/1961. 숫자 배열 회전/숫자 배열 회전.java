import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cube = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cube[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] rotated90 = rotate(cube, n);
            int[][] rotated180 = rotate(rotated90, n);
            int[][] rotated270 = rotate(rotated180, n);

            sb.append("#").append(t).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) sb.append(rotated90[i][j]);
                sb.append(" ");
                for (int j = 0; j < n; j++) sb.append(rotated180[i][j]);
                sb.append(" ");
                for (int j = 0; j < n; j++) sb.append(rotated270[i][j]);
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int[][] rotate(int[][] cube, int n) {
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = cube[i][j];
            }
        }
        return rotated;
    }
}
