import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static boolean[] visited;
    static int[] cost;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n + 1];

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                sum += bfs(i);
            }
        }

        if (sum > k) {
            System.out.print("Oh no");
        } else {
            System.out.print(sum);
        }
    }

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int minCost = cost[start];

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    minCost = Math.min(minCost, cost[next]);
                }
            }
        }
        return minCost;
    }
}
