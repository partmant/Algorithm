import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long result = 0;
	static int[] A, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		T = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		merge(0, N - 1);
		System.out.println(result);

	}

	public static void merge(int s, int e) {
		if (e - s < 1)
			return;

		int m = s + (e - s) / 2;
		merge(s, m);
		merge(m + 1, e);

		for (int i = s; i <= e; i++)
			T[i] = A[i];
		int i1 = s;
		int i2 = m + 1;
		int k = s;

		while (i1 <= m && i2 <= e) {
			if (T[i1] > T[i2]) {
				A[k] = T[i2];
                result += i2 - k;
                i2++;
			} else {
				A[k] = T[i1];
				i1++;
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
