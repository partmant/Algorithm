import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int n = sc.nextInt();
		int[] ls = new int[n];

		for (int i = 0; i < ls.length; i++) {
			n = sc.nextInt();
			ls[i] = n;
		}
		int max = Arrays.stream(ls).max().getAsInt();
		for (int i : ls)
			sum += i;
		System.out.println((sum * 100) / (double) (max * ls.length));
	}
}