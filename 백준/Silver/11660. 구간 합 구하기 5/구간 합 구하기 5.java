import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int array = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		long[][] S = new long[array + 1][array + 1];
		int[][] A = new int[array + 1][array + 1];

		for (int i = 1; i <= array; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= array; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= array; i++)
			for (int j = 1; j <= array; j++)
				S[i][j] = S[i][j - 1] + S[i - 1][j] - S[i - 1][j - 1] + A[i][j];

		for (int k = 0; k < quizNo; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			System.out.println(S[x2][y2] - S[x2][y1 - 1] - S[x1 - 1][y2] + S[x1 - 1][y1 - 1]);
		}
	}
}
