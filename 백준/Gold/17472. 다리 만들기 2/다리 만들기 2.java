import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static ArrayList<ArrayList<int[]>> sumList;
	static ArrayList<int[]> mList;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M, sNum;
	static PriorityQueue<Edge> pq;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		sNum = 1;
		sumList = new ArrayList();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] != true && map[i][j] != 0) {
					BFS(i, j);
					sNum++;
					sumList.add(mList);
				}
			}
		}

		pq = new PriorityQueue<Edge>();
		for (int i = 0; i < sumList.size(); i++) {
			ArrayList<int[]> now = sumList.get(i);
			for (int j = 0; j < now.size(); j++) {
				int r = now.get(j)[0];
				int c = now.get(j)[1];
				int num = map[r][c];
				for (int d = 0; d < 4; d++) {
					int tempR = dr[d];
					int tempC = dc[d];
					int bLength = 0;

					while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
						if (map[r + tempR][c + tempC] == num)
							break;
						else if (map[r + tempR][c + tempC] != 0) {
							if (bLength > 1)
								pq.add(new Edge(num, map[r + tempR][c + tempC], bLength));
							break;
						} else
							bLength++;

						if (tempR < 0)
							tempR--;
						else if (tempR > 0)
							tempR++;
						else if (tempC < 0)
							tempC--;
						else if (tempC > 0)
							tempC++;
					}
				}
			}
		}

		parent = new int[sNum];
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		int useEdge = 0;
		int result = 0;
		while (!pq.isEmpty()) {
			if (useEdge == sNum - 2)
				break;
			Edge now = pq.poll();
			if (find(now.s) != find(now.e)) {
				union(now.s, now.e);
				result += now.v;
				useEdge++;
			}
		}

		if (useEdge == sNum - 2)
			System.out.println(result);
		else
			System.out.println(-1);

	}

	static void BFS(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		mList = new ArrayList();
		visited[i][j] = true;
		int[] start = { i, j };
		q.add(start);
		mList.add(start);
		map[i][j] = sNum;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];

			for (int d = 0; d < 4; d++) {
				int tempR = dr[d];
				int tempC = dc[d];

				while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
					if (visited[r + tempR][c + tempC] == false && map[r + tempR][c + tempC] != 0)
						addNode(r + tempR, c + tempC, q);
					else
						break;
					if (tempR < 0)
						tempR--;
					else if (tempR > 0)
						tempR++;
					else if (tempC < 0)
						tempC--;
					else if (tempC > 0)
						tempC++;
				}
			}
		}
	}

	static void addNode(int i, int j, Queue<int[]> q) {
		map[i][j] = sNum;
		visited[i][j] = true;
		int[] temp = { i, j };
		mList.add(temp);
		q.add(temp);
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}

	static void union(int a, int b) {
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