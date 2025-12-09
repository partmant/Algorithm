import java.io.*;
import java.util.*;

class Main {
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};
    static int N;
    static int M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            boolean[][] visited = new boolean[N][M];
            boolean[][] field = new boolean[N][M];
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                field[y][x] = true;
            }
            
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j]) {
                        dfs(field, i, j);
                        count++;
                    }
                }
            }
            
            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void dfs(boolean[][] field, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M) {
            return;
        }
        if (!field[r][c]) {
            return;
        }
        
        field[r][c] = false;
        
        for (int d = 0; d < 4; d++) {
            dfs(field, r + dr[d], c + dc[d]);
        }
    }
}
