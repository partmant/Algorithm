import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int p, d, v;

		Edge(int p, int d, int v) {
			this.p = p;
			this.d = d;
			this.v = v;
		}
	}

	static int[] parent;
	static int[] rank;


	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
	    a = find(a);
	    b = find(b);

	    if (a != b) parent[b] = a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(edges, (e1, e2) -> e2.v - e1.v);

		parent = new int[N + 1];
		rank = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
		    parent[i] = i;
		    rank[i] = 0;
		}
		
        boolean connected = false;
		for (Edge e : edges) {
			union(e.p, e.d);
			if (find(A) == find(B)) {
				System.out.println(e.v);
				connected = true;
				break;
			}
		}
		
		if (!connected) {
            System.out.println(0);
        }
	}
}
