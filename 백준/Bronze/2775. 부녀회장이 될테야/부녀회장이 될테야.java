import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] dp = new int[15][15];

		for (int i = 1; i <= 14; i++) {
			dp[0][i] = i;
			dp[i][1] = 1;
		}

		for (int i = 1; i <= 14; i++)
			for (int j = 2; j <= 14; j++)
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			System.out.println(dp[n][k]);
		}
	}
}