import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final int MOD = 1_000_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[K + 1][N + 1];
		
		for (int j = 0; j <= N; j++) {
			dp[1][j] = 1;
		}
		
		for (int i = 2; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
				}
			}
		}
		
		System.out.println(dp[K][N]);
	}
}
