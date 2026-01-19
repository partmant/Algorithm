import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static class Node {
		Node[] child = new Node[26];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);

		Node root = new Node();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			Node cur = root;

			for (int j = 0; j < s.length(); j++) {
				int idx = s.charAt(j) - 'a';
				if (cur.child[idx] == null) {
					cur.child[idx] = new Node();
				}
				cur = cur.child[idx];
			}
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			Node cur = root;
			boolean isPrefix = true;

			for (int j = 0; j < s.length(); j++) {
				int idx = s.charAt(j) - 'a';
				if (cur.child[idx] == null) {
					isPrefix = false;
					break;
				}
				cur = cur.child[idx];
			}

			if (isPrefix)
				cnt++;
		}

		System.out.print(cnt);
	}
}
