import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] values = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			values[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(values);

		long best = Long.MAX_VALUE;
		long a = 0, b = 0, c = 0;

		for (int i = 0; i < N - 2; i++) {
			int l = i + 1, r = N - 1;

			while (l < r) {
				long sum = values[i] + values[l] + values[r];

				if (Math.abs(sum) < best) {
					best = Math.abs(sum);
					a = values[i];
					b = values[l];
					c = values[r];
				}

				if (sum > 0)
					r--;
				else
					l++;
			}
		}

		System.out.println(a + " " + b + " " + c);
	}
}
