import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		sc.close();

		int price;

		if (a == b && b == c)
			price = 10000 + a * 1000;
		else if (a == b || a == c)
			price = 1000 + a * 100;

		else if (b == c)
			price = 1000 + b * 100;
		else
			price = 100 * (Math.max(a, Math.max(b, c)));

		System.out.println(price);
	}
}