import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private final int[] dr = { 0, 1, 0, -1 };
	private final int[] dc = { 1, 0, -1, 0 };

	private int row;
	private int col;
	private char[][] map;

	public int solution(String[] maps) {
		row = maps.length;
		col = maps[0].length();
		map = new char[row][col];

		Point start = null;
		Point lever = null;
		Point end = null;

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				map[r][c] = maps[r].charAt(c);

				if (map[r][c] == 'S') {
					start = new Point(r, c);
				} else if (map[r][c] == 'L') {
					lever = new Point(r, c);
				} else if (map[r][c] == 'E') {
					end = new Point(r, c);
				}
			}
		}

		int startToLever = bfs(start, lever);
		int leverToEnd = bfs(lever, end);

		if (startToLever == -1 || leverToEnd == -1) {
			return -1;
		}

		return startToLever + leverToEnd;
	}

	private int bfs(Point start, Point target) {
		boolean[][] visited = new boolean[row][col];
		Queue<Point> queue = new LinkedList<>();

		queue.add(start);
		visited[start.r][start.c] = true;

		int distance = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Point current = queue.poll();

				if (current.r == target.r && current.c == target.c) {
					return distance;
				}

				for (int d = 0; d < 4; d++) {
					int nextR = current.r + dr[d];
					int nextC = current.c + dc[d];

					if (!canMove(nextR, nextC) || visited[nextR][nextC]) {
						continue;
					}

					visited[nextR][nextC] = true;
					queue.add(new Point(nextR, nextC));
				}
			}

			distance++;
		}

		return -1;
	}

	private boolean canMove(int r, int c) {
		return r >= 0 && r < row && c >= 0 && c < col && map[r][c] != 'X';
	}

	private static class Point {
		int r;
		int c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
