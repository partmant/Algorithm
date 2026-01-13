import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n > 0)
				right.add(n);
			else
				left.add(-n);
		}

		Collections.sort(left, Collections.reverseOrder());
		Collections.sort(right, Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < left.size(); i += M) {
			sum += left.get(i) * 2;
		}
		for (int i = 0; i < right.size(); i += M) {
			sum += right.get(i) * 2;
		}

		int max = 0;
		if (!left.isEmpty())
			max = left.get(0);
		if (!right.isEmpty())
			max = Math.max(max, right.get(0));

		System.out.print(sum - max);
	}
}
