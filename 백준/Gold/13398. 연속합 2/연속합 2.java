import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		int[] DP1 = new int[N];
		DP1[0] = A[0];
		for (int i = 1; i < N; i++)
			DP1[i] = Math.max(A[i], DP1[i - 1] + A[i]);

		int[] DP2 = new int[N];
		DP2[N-1] = A[N-1];
		for (int i = N - 2; i >= 0; i--)
			DP2[i] = Math.max(A[i], DP2[i + 1] + A[i]);

		int max = A[0];
		for (int i = 1; i < N; i++)
			max = Math.max(max, DP1[i]);

		for (int i = 1; i < N - 1; i++)
			max = Math.max(max, DP1[i - 1] + DP2[i + 1]);

		System.out.println(max);
	}
}