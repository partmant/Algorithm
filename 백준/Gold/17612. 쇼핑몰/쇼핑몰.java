import java.io.*;
import java.util.*;

class Main {
    static class Counter {
        int idx;
        int id;
        int time;

        Counter(int idx, int id, int time) {
            this.idx = idx;
            this.id = id;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Counter> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.time != b.time) return a.time - b.time;
                return a.idx - b.idx;
            }
        );
        
        for (int i = 1; i <= K; i++) {
            pq.add(new Counter(i, 0, 0));
        }

        PriorityQueue<Counter> out = new PriorityQueue<>(
            (a, b) -> {
                if (a.time != b.time) return a.time - b.time;
                return b.idx - a.idx;
            }
        );
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int customerId = Integer.parseInt(st.nextToken());
            int work = Integer.parseInt(st.nextToken());

            Counter c = pq.poll();
            
            int finishTime = c.time + work;
            
            c.time = finishTime;
            c.id = customerId;
            pq.add(c);

            out.add(new Counter(c.idx, customerId, finishTime));
        }

        long answer = 0;
        int order = 1;

        while (!out.isEmpty()) {
            Counter c = out.poll();
            answer += (long) order * c.id;
            order++;
        }

        System.out.println(answer);
    }
}
