import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static int[] value;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			A[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
		}

		value = new int[N + 1];
		visited = new boolean[N + 1];

		for (int s = 1; s <= N; s++) {
			Arrays.fill(visited, false);
			bfs(s);
		}

		int maxV = 0;
		for (int i = 1; i <= N; i++)
			maxV = Math.max(maxV, value[i]);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++)
			if (value[i] == maxV)
				sb.append(i).append(' ');
		System.out.println(sb.toString().trim());
	}

	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int nxt : A[cur]) {
				if (!visited[nxt]) {
					visited[nxt] = true;
					value[nxt]++;
					q.add(nxt);
				}
			}
		}
	}
}