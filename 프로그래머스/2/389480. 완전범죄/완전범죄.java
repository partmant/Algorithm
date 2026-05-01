import java.util.Arrays;

class Solution {
	public int solution(int[][] info, int n, int m) {
		int len = info.length;

		int[][] dp = new int[len + 1][m];
		int INF = 1000000;
		
		for (int i = 0; i <= len; i++) {
			Arrays.fill(dp[i], INF);
		}

		dp[0][0] = 0;

		for (int i = 1; i <= len; i++) {
			int aTrace = info[i - 1][0];
			int bTrace = info[i - 1][1];

			for (int j = 0; j < m; j++) {
				if (dp[i - 1][j] == INF)
					continue;

				int nextA = dp[i - 1][j] + aTrace;
				if (nextA < n) {
					dp[i][j] = Math.min(dp[i][j], nextA);
				}

				int nextB = j + bTrace;
				if (nextB < m) {
					dp[i][nextB] = Math.min(dp[i][nextB], dp[i - 1][j]);
				}
			}
		}

		int answer = INF;
		for (int j = 0; j < m; j++) {
			answer = Math.min(answer, dp[len][j]);
		}

		return (answer >= INF) ? -1 : answer;
	}
}
