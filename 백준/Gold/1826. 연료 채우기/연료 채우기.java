import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	static class Station {
		int pos; 
		int fuel;

		Station(int p, int f) {
			pos = p;
			fuel = f;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Station[] arr = new Station[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Station(a, b);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		Arrays.sort(arr, (a, b) -> a.pos - b.pos);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int idx = 0;
		int cnt = 0;
		int fuel = P;

		while (fuel < L) {
			while (idx < N && arr[idx].pos <= fuel) {
				pq.add(arr[idx].fuel);
				idx++;
			}

			if (pq.isEmpty()) {
				System.out.println(-1);
				return;
			}

			fuel += pq.poll();
			cnt++;
		}

		System.out.println(cnt);
	}
}
