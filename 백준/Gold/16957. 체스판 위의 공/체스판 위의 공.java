import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static final int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int R, C;
	static int[][] values;
	static int[] parent;

	static int idxOf(int r, int c) {
		return r * C + c;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		values = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				values[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int size = R * C;
		parent = new int[size];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int bestR = r;
				int bestC = c;
				int bestVal = values[r][c];

				for (int d = 0; d < 8; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;

					if (values[nr][nc] < bestVal) {
						bestVal = values[nr][nc];
						bestR = nr;
						bestC = nc;
					}
				}

				parent[idxOf(r, c)] = idxOf(bestR, bestC);
			}
		}

		int[] answer = new int[size];
		for (int i = 0; i < size; i++) {
			int root = find(i);
			answer[root]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (c > 0)
					sb.append(' ');
				sb.append(answer[idxOf(r, c)]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}
