import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();

		long answer = 0;
		long start = 1, end = k, middle;

		while (start <= end) {
			middle = (start + end) / 2;
			long count = 0;

			for (int i = 1; i <= N; i++)
				count += Math.min(middle / i, N);

			if (count < k)
				start = middle + 1;
			else {
				answer = middle;
				end = middle - 1;
			}
		}
		System.out.println(answer);
	}

}
