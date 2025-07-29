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
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<ArrayList<Node>> A = new ArrayList<>();
		ArrayList<ArrayList<Node>> reverseA = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			A.add(new ArrayList<Node>());
			reverseA.add(new ArrayList<Node>());
		}

		int[] indegree = new int[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			A.get(start).add(new Node(end, value));
			reverseA.get(end).add(new Node(start, value));
			indegree[end]++;
		}

		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(from);
		int[] result = new int[V + 1];
		while (!q.isEmpty()) {
			int now = q.poll();
			for (Node nextN : A.get(now)) {
				indegree[nextN.next]--;
				result[nextN.next] = Math.max(result[now] + nextN.value, result[nextN.next]);
				if (indegree[nextN.next] == 0)
					q.offer(nextN.next);
			}
		}

		int count = 0;
		boolean[] visited = new boolean[V + 1];
		q = new LinkedList<Integer>();
		q.offer(to);
		visited[to] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (Node nextN : reverseA.get(now)) {
				if (result[nextN.next] + nextN.value == result[now]) {
					count++;
					if (visited[nextN.next] == false) {
						visited[nextN.next] = true;
						q.offer(nextN.next);
					}
				}
			}
		}
		System.out.print(result[to] + " " + count);
	}
}

class Node {
	int next;
	int value;

	Node(int next, int value) {
		this.next = next;
		this.value = value;
	}
}
