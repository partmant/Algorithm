import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int max;
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
        	}
            
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            	graph[a].add(b);
                graph[b].add(a);
            }
            
            visited = new boolean[N + 1];
            max = 1;
            
            for (int i = 1; i <= N; i++) {
                visited[i] = true;
                dfs(i, 1);
                visited[i] = false;
            }
            
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static void dfs(int now, int depth) {
        max = Math.max(max, depth);

        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}
