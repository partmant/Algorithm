import java.util.*;

class Solution {
	private static final int[] dr = { -1, 1, 0, 0 };
	private static final int[] dc = { 0, 0, -1, 1 };
	private static int rows, cols;

	public int solution(int[][] land) {
		rows = land.length;
		cols = land[0].length;

		boolean[][] visited = new boolean[rows][cols];
		int[] oilByColumn = new int[cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (land[r][c] == 1 && !visited[r][c]) {
					bfs(land, visited, oilByColumn, r, c);
				}
			}
		}

		int answer = 0;

		for (int oil : oilByColumn) {
			answer = Math.max(answer, oil);
		}

		return answer;
	}

	private void bfs(int[][] land, boolean[][] visited, int[] oilByColumn, int startR, int startC) {
		Queue<int[]> queue = new LinkedList<>();
		Set<Integer> columns = new HashSet<>();

		queue.offer(new int[] { startR, startC });
		visited[startR][startC] = true;

		int oilSize = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];

			oilSize++;
			columns.add(c);

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
					continue;
				}

				if (visited[nr][nc]) {
					continue;
				}

				if (land[nr][nc] == 0) {
					continue;
				}

				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc });
			}
		}

		for (int col : columns) {
			oilByColumn[col] += oilSize;
		}
	}
}
