import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() / 4;
		String s = "long ".repeat(n) + "int";

		System.out.println(s);
	}
}