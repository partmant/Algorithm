import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(st.nextToken());
                q.add(new int[]{i, value});
                pq.add(value);
            }

            int count = 0;

            while (true) {
                int[] now = q.poll();

                if (now[1] == pq.peek()) {
                    pq.poll();
                    count++;

                    if (now[0] == m) {
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    q.add(now);
                }
            }
        }
        
        sb.setLength(sb.length() - 1);

        System.out.print(sb);
    }
}
