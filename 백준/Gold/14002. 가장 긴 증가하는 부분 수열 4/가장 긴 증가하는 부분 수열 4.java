import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] nums = new int[N];
		int[] dp = new int[N];
		int[] parent = new int[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
			parent[i] = -1;
		}

		int maxLen = 1;
		int lastIdx = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					parent[i] = j;
				}
			}

			if (dp[i] > maxLen) {
				maxLen = dp[i];
				lastIdx = i;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(maxLen).append('\n');

        ArrayList<Integer> lis = new ArrayList<>();

        while (lastIdx != -1) {
            lis.add(nums[lastIdx]);
            lastIdx = parent[lastIdx];
        }

        Collections.reverse(lis);

        for (int x : lis) {
        	sb.append(x).append(' ');
        }
        
        System.out.println(sb.toString());
	}
}
