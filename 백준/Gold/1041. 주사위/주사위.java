import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();

		long[] dice = new long[6];
		for (int i = 0; i < 6; i++) {
			dice[i] = sc.nextLong();
		}

		if (N == 1) {
            long sum = 0;
            long max = 0;
            for (long value : dice) {
                sum += value;
                max = Math.max(max, value);
            }
            System.out.println(sum - max);
            return;
        }

		long minA = Math.min(dice[0], dice[5]);
		long minB = Math.min(dice[1], dice[4]);
		long minC = Math.min(dice[2], dice[3]);

		long m1 = Math.min(minA, Math.min(minB, minC)); // 1면 최솟값
		long m2 = Math.min(minA + minB, Math.min(minA + minC, minB + minC)); // 2면 최솟값
		long m3 = minA + minB + minC;

		long side3 = 4;
		long side2 = 4 * (N - 1) + 4 * (N - 2);
		long side1 = 5 * (N - 2) * (N - 2) + 4 * (N - 2);

		long result = side3 * m3 + side2 * m2 + side1 * m1;
		System.out.println(result);
	}
}
