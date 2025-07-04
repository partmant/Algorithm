import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = (sc.nextInt() * 60 + sc.nextInt() + sc.nextInt()) % (24 * 60);

		System.out.println((total / 60) + " " + (total % 60));
	}
}
