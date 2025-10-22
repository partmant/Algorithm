import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] flies = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    flies[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;

            for (int r = 0; r <= N - M; r++) {
                int sum = 0;
                for (int i = r; i < r + M; i++) {
                    for (int j = 0; j < M; j++) {
                        sum += flies[i][j];
                    }
                }
                max = Math.max(max, sum);

                for (int c = 1; c <= N - M; c++) {
                    for (int i = r; i < r + M; i++) {
                        sum -= flies[i][c - 1];
                        sum += flies[i][c + M - 1];
                    }
                    max = Math.max(max, sum);
                }
            }

            sb.append("#").append(testCase).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }
}
