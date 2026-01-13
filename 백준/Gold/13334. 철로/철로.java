import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Line {
		int l, r;

		Line(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Line[] arr = new Line[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Line(Math.min(a, b), Math.max(a, b));
		}

		int d = Integer.parseInt(br.readLine());

		Arrays.sort(arr, (a, b) -> a.r - b.r);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int answer = 0;

		for (Line cur : arr) {
			if (cur.r - cur.l > d)
				continue;

			pq.add(cur.l);

			while (!pq.isEmpty() && pq.peek() < cur.r - d) {
				pq.poll();
			}

			answer = Math.max(answer, pq.size());
		}

		System.out.println(answer);
	}
}
