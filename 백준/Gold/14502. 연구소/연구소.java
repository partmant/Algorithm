import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static int maxSafe = 0;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(maxSafe);
	}

	static void dfs(int start, int depth) {
		if (depth == 3) {
			spreadVirus();
			return;
		}

		for (int i = start; i < N * M; i++) {
			int r = i / M;
			int c = i % M;

			if (map[r][c] == 0) {
				map[r][c] = 1;
				dfs(i + 1, depth + 1);
				map[r][c] = 0;
			}
		}
	}

	static void spreadVirus() {
		int[][] copy = new int[N][M];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 2) {
					q.offer(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (copy[nr][nc] == 0) {
					copy[nr][nc] = 2;
					q.offer(new int[] { nr, nc });
				}
			}
		}

		countSafe(copy);
	}

	static void countSafe(int[][] board) {
		int safe = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0)
					safe++;
			}
		}

		maxSafe = Math.max(maxSafe, safe);
	}
}
