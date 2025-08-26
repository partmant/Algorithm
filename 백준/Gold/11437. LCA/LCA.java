import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] depth;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			tree[s].add(e);
			tree[e].add(s);
		}

		depth = new int[N + 1];
		parent = new int[N + 1];
		visited = new boolean[N + 1];

		BFS(1);

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(LCA(a, b));
		}
	}

	static void BFS(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i);
		visited[i] = true;
		int level = 1;
		int size = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : tree[now]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
					parent[next] = now;
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
		while (depth[a] != depth[b]){
			a = parent[a];
        }
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
}