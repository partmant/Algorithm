import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS = new int[N];
		int[] LDS = new int[N];
		
		Arrays.fill(LIS, 1);
		Arrays.fill(LDS, 1);
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
		}
		
		for (int i = N - 2; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (nums[j] < nums[i]) {
					LDS[i] = Math.max(LDS[i], LDS[j] + 1);
				}
			}
		}
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
            answer = Math.max(answer, LIS[i] + LDS[i] - 1);
        }
		
		System.out.println(answer);
	}
}
