import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		int answer = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			int y = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek() > y) {
				stack.pop();
			}

			if (!stack.isEmpty() && stack.peek() == y)
				continue;

			if (y > 0) {
				stack.push(y);
				answer++;
			}
		}

		System.out.println(answer);
	}
}
