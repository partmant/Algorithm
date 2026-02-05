import java.io.*;
import java.util.*;

public class Main {

	static class Bridge {
		int a;
		int b;
		int c;

		Bridge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Bridge> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new Bridge(a, b, c));
		}

		list.sort((b1, b2) -> Integer.compare(b2.c, b1.c));

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}

		for (Bridge bridge : list) {
			union(bridge.a, bridge.b);
			
			if (find(start) == find(target)) {
				System.out.println(bridge.c);
				return;
			}
		}
		
		System.out.println(0);
	}
	
	public static int find(int a) {
		if (parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}

	public static void union(int a, int b) {
		int ra = find(a);
		int rb = find(b);
		
		if (ra != rb) {
			parent[rb] = ra;
		}
	}
}
