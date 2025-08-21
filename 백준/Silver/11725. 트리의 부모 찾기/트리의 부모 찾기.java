import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static ArrayList<Integer>[] A;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		result = new int[N + 1];

		A = new ArrayList[N + 1];
		for (int i = 1; i < A.length; i++) {
			A[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}

		DFS(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
	}

	public static void DFS(int a) {
		visited[a] = true;

		for (int i : A[a]) {
			if (visited[i] == false) {
				result[i] = a;
				DFS(i);
			}
		}
	}
}
