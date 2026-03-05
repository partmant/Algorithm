import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Jewel {
        int weight;
        int value;

        Jewel(int w, int v) {
            weight = w;
            value = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(M, V);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (a, b) -> a.weight - b.weight);

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;
        int idx = 0;

        for (int i = 0; i < K; i++) {
            while (idx < N && jewels[idx].weight <= bags[i]) {
                pq.add(jewels[idx].value);
                idx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }
}
