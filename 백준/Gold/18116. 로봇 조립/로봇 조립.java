import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	static int[] parent = new int[1000001];
	static int[] size = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("I")) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			} else if (command.equals("Q")) {
				int a = Integer.parseInt(st.nextToken());
				int root = find(a);
				sb.append(size[root]).append("\n");
			}
		}

		System.out.println(sb);
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int a, int b) {
	    int ra = find(a);
	    int rb = find(b);

	    if (ra == rb) return;

	    if (size[ra] < size[rb]) {
	        parent[ra] = rb;
	        size[rb] += size[ra];
	    } else {
	        parent[rb] = ra;
	        size[ra] += size[rb];
	    }
	}
}
