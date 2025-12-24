import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sb.append(st.nextToken());
        }

        String start = sb.toString();

        char[] arr = start.toCharArray();
        Arrays.sort(arr);
        String target = new String(arr);

        System.out.print(bfs(start, target));
    }

    static int bfs(String start, String target) {
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> dist = new HashMap<>();

        q.offer(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            String now = q.poll();
            int cnt = dist.get(now);

            if (now.equals(target)) return cnt;

            for (int i = 0; i <= N - K; i++) {
                String next = reverse(now, i, i + K - 1);
                if (!dist.containsKey(next)) {
                    dist.put(next, cnt + 1);
                    q.offer(next);
                }
            }
        }

        return -1;
    }

    static String reverse(String s, int b, int e) {
        char[] arr = s.toCharArray();
        while (b < e) {
            char tmp = arr[b];
            arr[b] = arr[e];
            arr[e] = tmp;
            b++;
            e--;
        }
        return new String(arr);
    }
}
