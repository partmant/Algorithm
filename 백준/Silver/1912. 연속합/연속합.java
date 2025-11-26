import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int maxSum = -1001;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (sum + num > 0) {
				sum += num;
				maxSum = Math.max(maxSum, sum);
			} else {
				sum = 0;
				maxSum = Math.max(maxSum, num);
			}
		}

		System.out.print(maxSum);
	}
}