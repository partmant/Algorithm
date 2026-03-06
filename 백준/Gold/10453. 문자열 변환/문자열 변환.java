import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			char[] A = st.nextToken().toCharArray();
			char[] B = st.nextToken().toCharArray();

			int count = 0;
			int n = A.length;

			for (int i = 0; i < n; i++) {
				if (A[i] == B[i])
					continue;

				int j = i + 1;
				while (j < n && A[j] != B[i]) {
					j++;
				}

				while (j > i) {
					char temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
					j--;
					count++;
				}
			}

			sb.append(count).append('\n');
		}

		System.out.print(sb);
	}
}
