import java.io.*;
import java.util.*;

public class Main {
    
    static class Task {
        int d, w;
        Task(int d, int w) {
            this.d = d;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Task[] tasks = new Task[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(d, w);
        }

        Arrays.sort(tasks, (a, b) -> a.d - b.d);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Task t : tasks) {
            pq.add(t.w);
            if (pq.size() > t.d) {
                pq.poll();
            }
        }

        long ans = 0;
        while (!pq.isEmpty()) ans += pq.poll();
        
        System.out.println(ans);
    }
}
