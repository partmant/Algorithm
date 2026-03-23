import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][][] dp = new long[N + 1][10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int len = 1; len < N; len++) {
            for (int last = 0; last <= 9; last++) {
                for (int mask = 0; mask < (1 << 10); mask++) {
                    long cur = dp[len][last][mask];
                    if (cur == 0) continue;

                    if (last > 0) {
                        int nextMask = mask | (1 << (last - 1));
                        dp[len + 1][last - 1][nextMask] =
                                (dp[len + 1][last - 1][nextMask] + cur) % MOD;
                    }

                    if (last < 9) {
                        int nextMask = mask | (1 << (last + 1));
                        dp[len + 1][last + 1][nextMask] =
                                (dp[len + 1][last + 1][nextMask] + cur) % MOD;
                    }
                }
            }
        }

        long answer = 0;
        int fullMask = (1 << 10) - 1;

        for (int last = 0; last <= 9; last++) {
            answer = (answer + dp[N][last][fullMask]) % MOD;
        }

        System.out.println(answer);
    }
}
