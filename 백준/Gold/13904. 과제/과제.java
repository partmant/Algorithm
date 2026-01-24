import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.add(new int[] { d, w });
			max = Math.max(max, d);
		}

		Collections.sort(list, (a, b) -> {
			if (a[1] != b[1])
				return b[1] - a[1];
			return b[0] - a[0];
		});

		int sum = 0;
		for (int i = max; i > 0; i--) {
			for (int j = 0; j < list.size(); j++) {
				int[] cur = list.get(j);
				if (cur[0] >= i) {
					sum += cur[1];
					list.remove(j);
					break;
				}
			}
		}

		System.out.println(sum);
	}
}
