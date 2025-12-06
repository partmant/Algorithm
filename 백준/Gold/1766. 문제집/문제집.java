import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            graph[s].add(e);
            indegree[e]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();        
        
        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now).append(" ");
            
            for (int next : graph[now]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
        
        System.out.print(sb);
    }
}
