import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] indegree = new int[N + 1];
		int[] buildTime = new int[N + 1];
        
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		for (int i = 0; i <= N; i++)
		    A.add(new ArrayList<Integer>());
        
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			buildTime[i] = Integer.parseInt(st.nextToken());
			for (int j = Integer.parseInt(st.nextToken()); j > 0; j = Integer.parseInt(st.nextToken())) {
				A.get(j).add(i);
				indegree[i]++;
			}
		}
        
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++)
			if (indegree[i] == 0)
				q.offer(i);
        
		int[] result = new int[N + 1];
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : A.get(now)) {
				indegree[next]--;
				result[next] = Math.max(result[next], result[now] + buildTime[now]);
				if (indegree[next] == 0)
					q.offer(next);
			}
		}
        
		for (int i = 1; i <= N; i++)
			System.out.println(result[i] + buildTime[i]);
	}
}
