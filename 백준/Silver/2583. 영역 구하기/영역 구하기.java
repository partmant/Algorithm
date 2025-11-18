import java.util.*;
import java.io.*;

public class Main {
    static final int[] dr = {0, -1, 0, 1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[M][N];

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

        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> areas = new ArrayList<>();
        int count = 0;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c]) {
                    continue;
                }

                q.add(new int[]{r, c});
                board[r][c] = true;
                count++;
                int area = 1;

                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nextR = now[0] + dr[d];
                        int nextC = now[1] + dc[d];

                        if (nextR >= 0 && nextR < M
                                && nextC >= 0 && nextC < N) {
                            if (!board[nextR][nextC]) {
                                q.add(new int[]{nextR, nextC});
                                board[nextR][nextC] = true;
                                area++;
                            }
                        }
                    }
                }
                areas.add(area);
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
}
