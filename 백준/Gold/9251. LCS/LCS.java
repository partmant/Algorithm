import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		int n = A.length();
        int m = B.length();
		
		int dp[][] = new int[n + 1][B.length() + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					} 
				else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		
		System.out.println(dp[n][B.length()]);
	}
}
