import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] dp = new int[31][31];

		for (int i = 0; i <= 30; i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
			dp[i][i] = 1;
		}

		for (int i = 2; i <= 30; i++)
			for (int j = 2; j < i; j++)
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println(dp[M][N]);
		}
	}
}
