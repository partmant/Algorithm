import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();

		if (N >> 1 < K)
			K = N - K;

		int num = 1, denum = 1;

		while (K > 0) {
			num *= N--;
			denum *= K--;
		}

		System.out.println(num / denum);
	}
}