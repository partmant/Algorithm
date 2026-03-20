import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Counsel {
		int startDate;
		int price;

		Counsel(int startDate, int price) {
			this.startDate = startDate;
			this.price = price;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Counsel>[] days = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			days[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			if (i + T <= N) {
				days[i + T].add(new Counsel(i + 1, P));
			}
		}

		int dp[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int max = dp[i - 1];
			ArrayList<Counsel> day = days[i];

			if (day.isEmpty()) {
				dp[i] = max;
				continue;
			}

			for (int j = 0; j < day.size(); j++) {
				Counsel counsel = day.get(j);
				int prev = counsel.startDate - 1;
				int price = counsel.price;
				max = Math.max(max, dp[prev] + price);
			}
			dp[i] = max;
		}

		System.out.println(dp[N]);
	}
}
