import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null && !line.isEmpty()) {
			String[] parts = line.split(" ");
			int A = Integer.parseInt(parts[0]);
			int B = Integer.parseInt(parts[1]);
			sb.append(A + B).append('\n');
		}

		System.out.print(sb);
	}
}