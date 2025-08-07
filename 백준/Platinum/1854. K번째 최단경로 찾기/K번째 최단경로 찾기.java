import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}

		PriorityQueue<Integer>[] dist = new PriorityQueue[N + 1];
		for (int i = 1; i <= N; i++) {
			dist[i] = new PriorityQueue<>(Comparator.reverseOrder());
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[1].offer(0);
		pq.offer(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int node = cur.node;
			int cost = cur.cost;

			if (dist[node].size() == K && dist[node].peek() < cost)
				continue;

			for (Node adj : graph[node]) {
				int next = adj.node;
				int newCost = cost + adj.cost;

				if (dist[next].size() < K) {
					dist[next].offer(newCost);
					pq.offer(new Node(next, newCost));
				} else if (dist[next].peek() > newCost) {
					dist[next].poll();
					dist[next].offer(newCost);
					pq.offer(new Node(next, newCost));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (dist[i].size() < K)
				sb.append(-1).append('\n');
			else
				sb.append(dist[i].peek()).append('\n');
		}
		System.out.print(sb);
	}
}

class Node implements Comparable<Node> {
	int node;
	int cost;

	Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}
