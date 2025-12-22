import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] nums = new int[K];
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            pq.add((long) nums[i]);
        }

        long now = 0;

        for (int i = 0; i < N; i++) {
            now = pq.poll();

            for (int num : nums) {
                long next = now * num;
                if (next > Integer.MAX_VALUE) break;

                pq.add(next);

                if (now % num == 0) break;
            }
        }

        System.out.println(now);
    }
}
