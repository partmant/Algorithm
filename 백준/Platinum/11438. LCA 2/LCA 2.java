import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[][] parent;
	static boolean[] visited;
	static int[] depth;
	static int kMax;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}

		depth = new int[N + 1];
		visited = new boolean[N + 1];
		int temp = 1;
		kMax = 0;

		while (temp <= N) {
			temp <<= 1;
			kMax++;
		}

		parent = new int[kMax + 1][N + 1];

		BFS(1);

		for (int k = 1; k <= kMax; k++)
			for (int n = 1; n <= N; n++)
				parent[k][n] = parent[k - 1][parent[k - 1][n]];

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			System.out.println(LCA(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

		}

	}

	static void BFS(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visited[a] = true;
		int level = 1;
		int size = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : tree[now]) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
					parent[0][next] = now;
					depth[next] = level;
				}
			}
			size--;

			if (size == 0) {
				size = q.size();
				level++;
			}
		}
	}

	static int LCA(int a, int b) {
		if (depth[a] < depth[b]) {
			int t = a;
			a = b;
			b = t;
		}

		for (int k = kMax; k >= 0; k--) {
			if ((1 << k) <= depth[a] - depth[b])
				a = parent[k][a];
		}

		for (int k = kMax; k >= 0; k--) {
			if (parent[k][a] != parent[k][b]) {
				a = parent[k][a];
				b = parent[k][b];
			}
		}

		int lca = a;

		if (a != b)
			lca = parent[0][lca];

		return lca;
	}
}