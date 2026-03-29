import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int S = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			if (S == 0)
				break;

			int maxIdx = i;

			for (int j = i + 1; j < N && j <= i + S; j++) {
				if (nums[j] > nums[maxIdx]) {
					maxIdx = j;
				}
			}

			if (maxIdx != i) {
				move(nums, i, maxIdx);
				S -= (maxIdx - i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int n : nums) {
			sb.append(n).append(' ');
		}
		System.out.println(sb);
	}

	private static void move(int[] arr, int s, int e) {
		int temp = arr[e];
		for (int i = e; i > s; i--) {
			arr[i] = arr[i - 1];
		}
		arr[s] = temp;
	}
}
