import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] colors = new int[M];
		int total = 0;
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			colors[i] = n;
			total += n;
		}

		int K = Integer.parseInt(br.readLine());

		if (K == 0) {
			System.out.println(1.0);
			return;
		}
		if (K > total) {
			System.out.println(0.0);
			return;
		}

		double result = 0.0;
		for (int c : colors) {
			if (c >= K) {
				double p = 1.0;
				for (int i = 0; i < K; i++) {
					p *= (double) (c - i) / (double) (total - i);
				}
				result += p;
			}
		}
		System.out.println(result);
	}
}