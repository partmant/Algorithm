import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] array = new int[N + 1];
		for (int i = 1; i < N + 1; i++)
			array[i] = i;

		int t = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			t = array[a];
			array[a] = array[b];
			array[b] = t;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < array.length; i++)
			sb.append(array[i]).append(' ');
		System.out.println(sb);
	}
}
