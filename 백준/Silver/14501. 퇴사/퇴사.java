import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			if (T[i] + i - 1 <= N)
				dp[i + T[i] - 1] = Math.max(dp[i - 1] + P[i], dp[i + T[i] - 1]);

			dp[i] = Math.max(dp[i], dp[i - 1]);
		}
		System.out.println(dp[N]);
	}
}