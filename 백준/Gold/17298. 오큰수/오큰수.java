import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] R = new int[N];

		Stack<Integer> S = new Stack<>();

		S.push(0);
		for (int i = 1; i < N; i++) {
			while (!S.isEmpty() && A[S.peek()] < A[i]) {
				R[S.pop()] = A[i];
			}
			S.push(i);
		}
		while (!S.isEmpty()) {
			R[S.pop()] = -1;
		}
		for (int i : R) {
			bw.write(i + " ");
		}

		bw.flush();
	}

}
