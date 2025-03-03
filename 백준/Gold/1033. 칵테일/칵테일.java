import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] A;
	static boolean[] visited;
	static long LCM; // 모든 수의 최소 공배수
	static long[] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		A = new ArrayList[N];
		visited = new boolean[N];
		LCM = 1;
		D = new long[N];

		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Node>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			A[a].add(new Node(b, p, q));
			A[b].add(new Node(a, q, p));
			LCM *= (p * q) / gcd(p, q);
		}

		D[0] = LCM;
		DFS(0); // 0번째 노드부터 시작
		long mgcd = D[0];

		for (int i = 1; i < N; i++) // 각 노드 관계의 최대 공약수 구하기
			mgcd = gcd(mgcd, D[i]);

		for (int i = 0; i < N; i++) {
			System.out.print(D[i] / mgcd + " ");
		}
	}

	public static void DFS(int Node) {
		visited[Node] = true;
		for (Node n : A[Node]) {
			int next = n.b;
			if (!visited[next]) {
				D[next] = D[Node] * n.q / n.p; // 비율로 다음 노드 값 계산
				DFS(next);
			}
		}
	}

	public static long gcd(long p, long q) {
		if (q == 0)
			return p;
		else
			return gcd(q, p % q);
	}
}

class Node {
	int b, p, q;

	public Node(int b, int p, int q) {
		this.b = b;
		this.p = p;
		this.q = q;
	}
}
