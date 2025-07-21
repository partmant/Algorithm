import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				for (int k = 0; k < r; k++) {
					sb.append(c);
				}
			}
			sb.append('\n');
		}

		System.out.print(sb);
	}
}
