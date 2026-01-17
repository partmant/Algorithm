import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static class Group {
        int size;
        int candy;

        Group(int size, int candy) {
            this.size = size;
            this.candy = candy;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] candy = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[N + 1];
        List<Group> groups = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            visited[i] = true;

            int size = 0;
            int sum = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();
                size++;
                sum += candy[cur];

                for (int next : graph[cur]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }

            groups.add(new Group(size, sum));
        }

        int[] dp = new int[K];
        for (Group g : groups) {
            for (int i = K - 1; i >= g.size; i--) {
                dp[i] = Math.max(dp[i], dp[i - g.size] + g.candy);
            }
        }

        System.out.println(dp[K - 1]);
    }
}
