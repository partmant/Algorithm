import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int leftIndex;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int treeHeight = 0;
		int length = N;

		while (length != 0) {
			length /= 2;
			treeHeight++;
		}

		int treeSize = (int) Math.pow(2, treeHeight + 1);
		leftIndex = treeSize / 2 - 1;
		tree = new int[treeSize + 1];

		for (int i = leftIndex + 1; i <= leftIndex + N; i++)
			tree[i] = Integer.parseInt(br.readLine());

		setTree(leftIndex);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			System.out.println(getMin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
	}

	static void setTree(int i) {
		while (i != 1) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
			i--;
		}
	}

	static int getMin(int s, int e) {
		int start = s + leftIndex;
		int end = e + leftIndex;
		int Min = Integer.MAX_VALUE;

		while (start <= end) {
			if (start % 2 == 1)
				Min = Math.min(Min, tree[start++]);
			if (end % 2 == 0)
				Min = Math.min(Min, tree[end--]);

			start /= 2;
			end /= 2;
		}
		return Min;
	}
}