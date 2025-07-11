import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] mod = new boolean[42];

		for (int i = 0; i < 10; i++)
			mod[Integer.parseInt(br.readLine()) % 42] = true;

		int count = 0;
		for (boolean v : mod) {
			if (v == true)
				count++;
		}
		System.out.println(count);

	}
}
