import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static PriorityQueue<Edge> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		pq = new PriorityQueue<Edge>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		int useEdge = 0;
		int result = 0;
		while (useEdge < V - 1) {
			Edge now = pq.poll();
			if (find(now.start) != find(now.end)) {
				union(now.start, now.end);
				result += now.value;
				useEdge++;
			}
		}
		System.out.println(result);
	}

	public static int find(int n) {
		if (parent[n] == n)
			return n;
		else
			return parent[n] = find(parent[n]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
	}
}

class Edge implements Comparable<Edge> {
	int start;
	int end;
	int value;

	Edge(int s, int e, int v) {
		this.start = s;
		this.end = e;
		this.value = v;
	}

	@Override
	public int compareTo(Edge o) {
		return this.value - o.value;
	}
}