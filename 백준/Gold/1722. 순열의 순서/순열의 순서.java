import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] factorial;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		factorial = new long[N + 1];
		used = new boolean[N + 1];

		factorial[0] = 1;
		for (int i = 1; i <= N; i++) {
			factorial[i] = factorial[i - 1] * i;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int type = Integer.parseInt(st.nextToken());

		if (type == 1) {
			long k = Long.parseLong(st.nextToken());

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (used[j])
						continue;

					if (k > factorial[N - i]) {
						k -= factorial[N - i];
					} else {
						System.out.print(j + " ");
						used[j] = true;
						break;
					}
				}
			}

		} else if (type == 2) {
			int[] orders = new int[N];
			for (int i = 0; i < N; i++) {
				orders[i] = Integer.parseInt(st.nextToken());
			}

			long result = 1;

			for (int i = 1; i <= N; i++) {
				int current = orders[i - 1];
				int count = 0;

				for (int j = 1; j < current; j++) {
					if (!used[j])
						count++;
				}

				result += count * factorial[N - i];
				used[current] = true;
			}
			System.out.println(result);
		}
	}
}