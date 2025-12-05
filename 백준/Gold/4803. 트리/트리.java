import java.io.*;
import java.util.*;

class Main {
    static int vCnt;
    static int eCnt;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vCnt = Integer.parseInt(st.nextToken());
            eCnt = Integer.parseInt(st.nextToken());

            if (vCnt == 0 && eCnt == 0) break;

            graph = new ArrayList[vCnt + 1];
            for (int i = 1; i <= vCnt; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < eCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            visited = new boolean[vCnt + 1];
            int treeCnt = 0;

            for (int i = 1; i <= vCnt; i++) {
                if (!visited[i]) {
                    if (!dfs(i, 0)) {
                        treeCnt++;
                    }
                }
            }

            sb.append("Case ").append(testCase).append(": ");
            
            if (treeCnt == 0) {
                sb.append("No trees.");
            } else if (treeCnt == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(treeCnt).append(" trees.");
            }
            
            sb.append("\n");

            testCase++;
        }

        System.out.print(sb);
    }

    static boolean dfs(int now, int parent) {
        visited[now] = true;

        for (int next : graph[now]) {
            if (!visited[next]) {
                if (dfs(next, now)) return true;
            }
            else if (next != parent) {
                return true;
            }
        }
        return false;
    }
}
