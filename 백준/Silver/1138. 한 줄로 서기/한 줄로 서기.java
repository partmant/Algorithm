import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		List<Integer> idx = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			idx.add(i);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			nums[idx.get(n)] = i;
			idx.remove(n);
		}
		
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}
}
