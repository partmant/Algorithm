import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[E + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		long[] dist = new long[V + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		dist[1] = 0;
		for (int i = 1; i < V; i++) {
			for (int j = 0; j < E; j++) {
				Edge edge = edges[j];
				if (dist[edge.start] != Long.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.price)
					dist[edge.end] = dist[edge.start] + edge.price;
			}
		}

		boolean isCycle = false;
		for (int j = 0; j < E; j++) {
			Edge edge = edges[j];
			if (dist[edge.start] != Long.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.price)
				isCycle = true;
		}

		if (isCycle)
			System.out.println(-1);
		else {
			for (int i = 2; i <= V; i++) {
				if (dist[i] == Long.MAX_VALUE)
					System.out.println(-1);
				else
					System.out.println(dist[i]);
			}
		}
	}
}

class Edge {
	int start, end, price;

	Edge(int s, int e, int p) {
		this.start = s;
		this.end = e;
		this.price = p;
	}
}
