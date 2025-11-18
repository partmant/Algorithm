import java.util.*;
import java.io.*;

public class Main {
    static final int[] dr = {0, -1, 0, 1};
    static final int[] dc = {1, 0, -1, 0};

    static int M, N;
    static boolean[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new boolean[M][N];

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    board[y][x] = true;
                }
            }
        }

        ArrayList<Integer> areas = new ArrayList<>();
        int count = 0;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!board[r][c]) {
                    int area = bfs(r, c);
                    count++;
                    areas.add(area);
                }
            }
        }

        Collections.sort(areas);

        sb.append(count).append("\n");
        for (int v : areas) {
            sb.append(v).append(" ");
        }
        sb.setLength(sb.length() - 1);

        System.out.print(sb);
    }

    static int bfs(int sr, int sc) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        board[sr][sc] = true;
        int area = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
                    if (!board[nr][nc]) {
                        board[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                        area++;
                    }
                }
            }
        }
        return area;
    }
}
