import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] bitmasks;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < 5) {
			System.out.println(0);
			return;
		}

		bitmasks = new int[N];
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			int bitmask = 0;
			for (int j = 0; j < word.length(); j++) {
				bitmask |= 1 << (word.charAt(j) - 'a');
			}
			bitmasks[i] = bitmask;
		}

		int learned = 0;
		learned |= (1 << ('a' - 'a'));
		learned |= (1 << ('n' - 'a'));
		learned |= (1 << ('t' - 'a'));
		learned |= (1 << ('i' - 'a'));
		learned |= (1 << ('c' - 'a'));

		dfs(0, 0, learned);

		System.out.println(max);
	}

	static void dfs(int idx, int depth, int learned) {
		if (depth == K - 5) {
			max = Math.max(max, readable(learned));
			return;
		}

		for (int i = idx; i < 26; i++) {
			if ((learned & (1 << i)) != 0)
				continue;

			dfs(i + 1, depth + 1, learned | (1 << i));
		}
	}

	static int readable(int learned) {
		int cnt = 0;

		for (int bitmask : bitmasks) {
			if ((bitmask & learned) == bitmask) {
				cnt++;
			}
		}

		return cnt;
	}
}
