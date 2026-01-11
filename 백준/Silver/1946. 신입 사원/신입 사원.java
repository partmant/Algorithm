import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new int[] { a, b });
			}

			list.sort((a, b) -> a[0] - b[0]);

			int count = 1;
			int best = list.get(0)[1];

			for (int i = 1; i < N; i++) {
				if (list.get(i)[1] < best) {
					count++;
					best = list.get(i)[1];
				}
			}

			sb.append(count).append("\n");
		}

		System.out.print(sb);
	}
}
