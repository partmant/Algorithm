import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int price = sc.nextInt(), N = sc.nextInt();
		int sum = 0;

		for (int i = 0; i < N; i++)
			sum += sc.nextInt() * sc.nextInt();

		if (price == sum)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}