import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		sc.close();

		for (int i = 1; i <= n; i++)
			bw.write(" ".repeat(n - i) + "*".repeat(i) + "\n");

		bw.flush();
	}
}
