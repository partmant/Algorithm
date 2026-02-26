import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    static int size;
    static boolean[][] visited;

    static int[] dr = {-2,-2,-1,-1,1,1,2,2};
    static int[] dc = {-1,1,-2,2,-2,2,-1,1};

    static class Node {
        int r, c, depth;

        Node(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            size = Integer.parseInt(br.readLine());
            visited = new boolean[size][size];

            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tr = Integer.parseInt(st.nextToken());
            int tc = Integer.parseInt(st.nextToken());

            System.out.println(bfs(sr, sc, tr, tc));
        }
    }

    static int bfs(int sr, int sc, int tr, int tc) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sr, sc, 0));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == tr && cur.c == tc) 
            	return cur.depth;

            for (int i = 0; i < 8; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr >= 0 && nr < size &&
                    nc >= 0 && nc < size &&
                    !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, cur.depth + 1));
                }
            }
        }
        
        return 0;
    }
}
