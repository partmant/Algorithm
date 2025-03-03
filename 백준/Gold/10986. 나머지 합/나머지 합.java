import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		long[] S = new long[N + 1];
		long[] R = new long[M];
		long answer = 0;

		for (int i = 1; i <= N; i++)
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			if (S[i] % M == 0)
				answer++;
			S[i] = S[i] % M;
			R[(int) (S[i] % M)]++;
		}

		for (int i = 0; i < M; i++) {
			if (R[i] > 1)
				answer += R[i] * (R[i] - 1) / 2;
		}
		System.out.println(answer);
	}
}