import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] a = new int[26];
		int n = 0;

		for (int i = 0; i < a.length; i++)
			a[i] = -1;

		for (int i = 0; i < s.length(); i++) {
			n = s.charAt(i) - 'a';
			if (a[n] < 0)
				a[n] = i;
		}

		for (int value : a) {
			System.out.print(value + " ");
		}

	}
}
