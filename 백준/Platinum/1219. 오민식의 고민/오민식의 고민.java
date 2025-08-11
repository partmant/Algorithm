import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Edge[] edges = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		long[] cityValue = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			cityValue[i] = Long.parseLong(st.nextToken());

		long[] fee = new long[N];
		Arrays.fill(fee, Long.MIN_VALUE);

		fee[S] = cityValue[S];
		for (int i = 0; i < N * 2 - 1; i++) {
			for (int j = 0; j < M; j++) {
				int start = edges[j].start;
				int end = edges[j].end;
				int price = edges[j].price;

				if (fee[start] == Long.MIN_VALUE)
					continue;
				else if (fee[start] == Long.MAX_VALUE)
					fee[end] = Long.MAX_VALUE;
				else if (fee[end] < fee[start] + cityValue[end] - price) {
					fee[end] = fee[start] + cityValue[end] - price;
					if (i >= N - 1)
						fee[end] = Long.MAX_VALUE;
				}
			}
		}

		if (fee[E] == Long.MIN_VALUE)
			System.out.println("gg");
		else if (fee[E] == Long.MAX_VALUE)
			System.out.println("Gee");
		else
			System.out.println(fee[E]);
	}
}

class Edge {
	int start, end, price;

	Edge(int s, int e, int p) {
		this.start = s;
		this.end = e;
		this.price = p;
	}
}
