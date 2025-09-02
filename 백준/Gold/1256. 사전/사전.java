import java.util.Scanner;

public class Main {
	static final long CAP = 1000000001;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		long[][] c = new long[N + M + 1][N + M + 1];
		for (int i = 0; i <= N+M; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == j)
					c[i][j] = 1;
				else {
					c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
					if (c[i][j] > 1000000000)
						c[i][j] = CAP;
				}
			}

		}
		if (K > c[N + M][N]) {
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();

		int a = N, z = M;
		while (a > 0 || z > 0) {
			if (a == 0) {
				sb.append('z');
				z--;
				continue;
			}

			if (z == 0) {
				sb.append('a');
				a--;
				continue;
			}

			long now = c[a - 1 + z][a - 1];
			if (K <= now) {
				sb.append('a');
				a--;
			} else {
				sb.append('z');
				z--;
				K -= now;
			}
		}
		System.out.println(sb.toString());
	}
}