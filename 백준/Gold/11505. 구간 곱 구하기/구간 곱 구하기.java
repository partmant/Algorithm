import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int tHeight = 0, length = N;

		while (length != 0) {
			length /= 2;
			tHeight++;
		}

		int tSize = (int) Math.pow(2, tHeight + 1);
		int leftIndex = tSize / 2 - 1;
		tree = new long[tSize + 1];

		for (int i = 1; i < tree.length; i++)
			tree[i] = 1;

		for (int i = leftIndex + 1; i <= leftIndex + N; i++)
			tree[i] = Long.parseLong(br.readLine());

		setTree(leftIndex);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1)
				changeVal(leftIndex + b, c);
			else if (a == 2) {
				b += leftIndex;
				c += leftIndex;

				System.out.println(getMul(b, (int) c));
			}
		}
		br.close();
	}

	static void setTree(int i) {
		while (i > 0) {
			tree[i] = tree[i << 1] * tree[(i << 1) + 1] % MOD;
			i--;
		}
	}

	static long getMul(int s, int e) {
		long result = 1;

		while (s <= e) {
			if (s % 2 == 1)
				result = result * tree[s++] % MOD;
			if (e % 2 == 0)
				result = result * tree[e--] % MOD;

			s >>= 1;
			e >>= 1;
		}
		return result;
	}

	static void changeVal(int i, long v) {
		tree[i] = v;
		while (i > 1) {
			i >>= 1;
			tree[i] = tree[i << 1] % MOD * tree[(i << 1) + 1] % MOD;
		}
	}
}