import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int startV = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Edge>> A = new ArrayList<>();
		for (int i = 0; i <= V; i++)
			A.add(new ArrayList<>());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			A.get(Integer.parseInt(st.nextToken()))
					.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int[] distance = new int[V + 1];
		for (int i = 0; i <= V; i++)
			distance[i] = Integer.MAX_VALUE;

		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		q.add(new Edge(startV, 0));
		distance[startV] = 0;
		boolean[] visited = new boolean[V + 1];
		while (!q.isEmpty()) {
			Edge now = q.poll();
			if (visited[now.nextV])
				continue;
			visited[now.nextV] = true;

			for (int i = 0; i < A.get(now.nextV).size(); i++) {
				Edge t = A.get(now.nextV).get(i);
				int next = t.nextV;
				int value = t.value;
				if (distance[next] > distance[now.nextV] + value) {
					distance[next] = value + distance[now.nextV];
					q.add(new Edge(next, distance[next]));
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (visited[i])
				System.out.println(distance[i]);
			else
				System.out.println("INF");
		}
	}
}

class Edge implements Comparable<Edge> {
	int nextV;
	int value;

	Edge(int nextV, int value) {
		this.nextV = nextV;
		this.value = value;
	}

	public int compareTo(Edge e) {
		if (this.value > e.value)
			return 1;
		else
			return -1;
	}
}
