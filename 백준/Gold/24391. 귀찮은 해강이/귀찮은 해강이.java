import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(find(a), find(b));
		}

		st = new StringTokenizer(br.readLine());

		int prev = 0;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (prev == 0 || prev != find(cur)) {
				cnt++;
			}
			prev = find(cur);
		}

		System.out.println(cnt - 1);
	}

	static int find(int n) {
		if (parent[n] == n)
			return n;
		return parent[n] = find(parent[n]);
	}

	static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);

		if (ra == rb)
			return;
		parent[rb] = parent[ra];
	}
}
