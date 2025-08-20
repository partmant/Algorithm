import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int result;
	static PriorityQueue<Edge> pq;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		parent = new int[N];

		for (int i = 0; i < N; i++)
			parent[i] = i;

		pq = new PriorityQueue<Edge>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < N; j++) {
				int a = s.charAt(j);
				int value = 0;

				if (a >= 'a' && a <= 'z') {
					value = a - 'a' + 1;
				} else if (a >= 'A' && a <= 'Z') {
					value = a - 'A' + 27;
				}

				result += value;

				if (i != j && value != 0)
					pq.add(new Edge(i, j, value));
			}
		}

		int useEdge = 0, sum = 0;

		while (!pq.isEmpty()) {
			Edge now = pq.poll();

			if (find(now.s) != find(now.e)) {
				union(now.s, now.e);
				sum += now.v;
				useEdge++;
			}
		}

		if (useEdge == N - 1)
			System.out.println(result - sum);
		else
			System.out.println(-1);
	}

	public static int find(int a) {
		if (a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
	}
}

class Edge implements Comparable<Edge> {
	int s;
	int e;
	int v;

	Edge(int s, int e, int v) {
		this.s = s;
		this.e = e;
		this.v = v;
	}

	@Override
	public int compareTo(Edge o) {
		return this.v - o.v;
	}
}