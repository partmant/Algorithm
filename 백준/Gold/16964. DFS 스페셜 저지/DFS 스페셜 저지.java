import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int[] input;
	static int idx = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		visited = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		input = new int[N];
		order = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			order[input[i]] = i;
		}

		if (input[0] != 1) {
			System.out.println(0);
			return;
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i], (a, b) -> order[a] - order[b]);
		}

		visited = new boolean[N + 1];
		dfs(1);

		if (idx == N) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static void dfs(int v) {
		visited[v] = true;

		if (input[idx] != v) {
			idx = -1;
			return;
		}

		idx++;

		for (int next : graph[v]) {
			if (!visited[next]) {
				dfs(next);
				if (idx == -1)
					return;
			}
		}
	}
}
