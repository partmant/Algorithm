import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int bCnt = Integer.parseInt(st.nextToken());
            int rCnt = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            int[] bTime = new int[bCnt + 1];
            for (int i = 1; i <= bCnt; i++) {
                bTime[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] indegree = new int[bCnt + 1];
            ArrayList<Integer>[] graph = new ArrayList[bCnt + 1];
            
            for (int i = 0; i <= bCnt; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < rCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                
                graph[s].add(e);
                indegree[e]++;
            }
            
            int dest = Integer.parseInt(br.readLine());

            int[] dp = new int[bCnt + 1];
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= bCnt; i++) {
                dp[i] = bTime[i];
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            
            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : graph[now]) {
                    indegree[next]--;

                    dp[next] = Math.max(dp[next], dp[now] + bTime[next]);

                    if (indegree[next] == 0) {
                        q.add(next);
                    }
                }
            }
            
            sb.append(dp[dest]).append("\n");
        }
        
        System.out.print(sb);
    }
}
