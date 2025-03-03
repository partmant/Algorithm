import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] A, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		T = new int[N + 1];

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(br.readLine());

		merge(0, N - 1);
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();

	}

	public static void merge(int s, int e) {
		if (e - s < 1) // 배열의 원소가 하나면 분할(재귀) 종료
			return;
		int m = s + (e - s) / 2;
		merge(s, m); // 더 작은 배열로 분할(재귀)
		merge(m + 1, e);
		for (int i = s; i <= e; i++)
			T[i] = A[i];

		int i1 = s;
		int i2 = m + 1;
		int k = s;
		while (i1 <= m && i2 <= e) { // merge 연산
			if (T[i1] <= T[i2]) {
				A[k] = T[i1];
				i1++;
			} else {
				A[k] = T[i2];
				i2++;
			}
			k++;
		}
		while (i1 <= m) {
			A[k] = T[i1];
			i1++;
			k++;
		}
		while (i2 <= e) {
			A[k] = T[i2];
			i2++;
			k++;
		}
	}
}
