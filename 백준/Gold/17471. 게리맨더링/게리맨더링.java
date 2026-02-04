import java.io.*;
import java.util.*;

public class Main {

	static int[] people;
	static ArrayList<Integer>[] graph;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		people = new int[N];
		graph = new ArrayList[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int mask = 1; mask < (1 << N) - 1; mask++) {

			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				if ((mask & (1 << i)) != 0)
					A.add(i);
				else
					B.add(i);
			}

			if (!isConnected(A))
				continue;
			if (!isConnected(B))
				continue;
			
			int diff = populationDiff(A, B);
			answer = Math.min(answer, diff);
		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

	}

	static boolean isConnected(List<Integer> group) {
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new LinkedList<>();

		q.add(group.get(0));
		visited[group.get(0)] = true;
		int count = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph[cur]) {
				if (!visited[next] && group.contains(next)) {
					visited[next] = true;
					q.add(next);
					count++;
				}
			}
		}
		return count == group.size();
	}

	static int populationDiff(List<Integer> A, List<Integer> B) {
		int sumA = 0;
		int sumB = 0;
		for (int a : A)
			sumA += people[a];
		for (int b : B)
			sumB += people[b];
		
		return Math.abs(sumA - sumB);
	}
}
