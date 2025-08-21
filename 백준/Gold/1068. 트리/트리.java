import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int result;
	static int dNode;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new boolean[N];
		tree = new ArrayList[N];
		dNode = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++)
			tree[i] = new ArrayList<Integer>();

		int root = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());

			if (n == -1)
				root = i;
			else {
				tree[i].add(n);
				tree[n].add(i);
			}
		}

		if (dNode == root)
			System.out.println(0);
		else {
			DFS(root);
			System.out.println(result);
		}
	}

	public static void DFS(int a) {
		visited[a] = true;
		int child = 0;

		for (int i : tree[a]) {
			if (visited[i] == false && i != dNode) {
				child++;
				DFS(i);
			}
		}
		if (child == 0)
			result++;
	}
}