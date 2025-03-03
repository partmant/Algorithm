import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		Deque<Node> dq = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());

			while (!dq.isEmpty() && dq.getLast().value > now) // 큐에 값이 있고, 마지막 값 > 들어올 값
				dq.removeLast();
			dq.addLast(new Node(i, now));

			if (dq.getFirst().index <= i - W) {
				dq.removeFirst();
			}
			bw.write(dq.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static class Node {
		public int value;
		public int index;

		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

}
