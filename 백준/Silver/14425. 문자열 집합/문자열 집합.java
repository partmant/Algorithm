import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		Node root = new Node();
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			Node now = root;

			for (int j = 0; j < s.length(); j++) {
				int c = s.charAt(j) - 'a';

				if (now.next[c] == null)
					now.next[c] = new Node();

				now = now.next[c];

				if (j == s.length() - 1)
					now.isEnd = true;
			}
		}

		int result = 0;
		for (int i = 0; i < M; i++) {
			String s = sc.next();
			Node now = root;

			for (int j = 0; j < s.length(); j++) {
				int c = s.charAt(j) - 'a';

				if (now.next[c] == null)
					break;

				now = now.next[c];

				if (j == s.length() - 1 && now.isEnd)
					result++;
			}
		}
		System.out.println(result);
	}
}

class Node {
	Node[] next = new Node[26];
	boolean isEnd;
}