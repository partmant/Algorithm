import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] A;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int depth[][];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new boolean[N][M];
		depth = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++)
				A[i][j] = Integer.parseInt(line.substring(j, j + 1)) > 0 ? true : false;
		}

		BFS(0, 0);
		System.out.println(depth[N - 1][M - 1]);
	}

	static void BFS(int n, int m) {
		Queue<int[]> Q = new LinkedList<>(); // 값이 x, y 두 개 이므로 배열타입 Queue 선언
		A[n][m] = false;
		Q.offer(new int[] { n, m });
		depth[n][m] += 1;

		while (!Q.isEmpty()) {
			int now[] = Q.poll();

			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if (x >= 0 && y >= 0 && x < N && y < M) { // 미로의 좌표 유효성
					if (A[x][y]) {
						A[x][y] = false;
						Q.add(new int[] { x, y });
						depth[x][y] = depth[now[0]][now[1]] + 1;
					}
				}
			}
		}
	}

}
