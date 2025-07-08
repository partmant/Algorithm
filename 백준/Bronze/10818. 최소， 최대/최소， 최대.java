import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int max = n, min = n;

		for (int i = 1; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			if (n > max)
				max = n;
			else if (n < min)
				min = n;
		}
		System.out.println(min + " " + max);
	}
}