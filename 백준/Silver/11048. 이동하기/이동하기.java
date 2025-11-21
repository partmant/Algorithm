import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rSize = Integer.parseInt(st.nextToken());
        int cSize = Integer.parseInt(st.nextToken());

        int[][] maze = new int[rSize][cSize];
        int[][] dp = new int[rSize][cSize];

        for (int i = 0; i < rSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cSize; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = maze[0][0];

        for (int j = 1; j < cSize; j++) {
            dp[0][j] = dp[0][j - 1] + maze[0][j];
        }

        for (int i = 1; i < rSize; i++) {
            dp[i][0] = dp[i - 1][0] + maze[i][0];
        }

        for (int i = 1; i < rSize; i++) {
            for (int j = 1; j < cSize; j++) {
                dp[i][j] = maze[i][j] + Math.max(
                    Math.max(dp[i - 1][j], dp[i][j - 1]),
                    dp[i - 1][j - 1]
                );
            }
        }

        System.out.println(dp[rSize - 1][cSize - 1]);
    }
}
