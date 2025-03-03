import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i < parent.length; i++)
			parent[i] = i;

		st = new StringTokenizer(br.readLine());
		int[] knows = new int[Integer.parseInt(st.nextToken())]; 
		for (int i = 0; i < knows.length; i++)
			knows[i] = Integer.parseInt(st.nextToken());

		int[] firstP = new int[M + 1]; 

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int[] A = new int[K];

			for (int j = 0; j < A.length; j++)
				A[j] = Integer.parseInt(st.nextToken());

			firstP[i] = A[0];
			if (K >= 2) {
				for (int k = 0; k < A.length - 1; k++)
					union(A[k], A[k + 1]);
			} else
				continue;
		}

		int result = M;
		for (int i = 1; i < firstP.length; i++) {
			for (int j = 0; j < knows.length; j++) {
				if (find(firstP[i]) == find(knows[j])) {
					result--;
					break;
				}
			}
		}
		System.out.println(result);

	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b)
			parent[b] = a;
	}

	public static int find(int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}
}
