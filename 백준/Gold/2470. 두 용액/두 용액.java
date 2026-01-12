import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] values = new int[N];
		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(values);

		int r = N - 1;
		int l = 0;
		int min = Integer.MAX_VALUE;
		int bestL = 0;
		int bestR = 0;

		while (l < r) {
			int sum = values[l] + values[r];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				bestR = r;
				bestL = l;
			}

			if (sum > 0)
				r--;
			else
				l++;
		}

		System.out.print(values[bestL] + " " + values[bestR]);
	}
}
