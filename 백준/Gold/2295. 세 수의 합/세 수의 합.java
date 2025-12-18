import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] sum = new int[N * N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum[idx++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sum);

        for (int i = N - 1; i >= 0; i--) {
            int u = arr[i];
            for (int j = 0; j < N; j++) {
                int target = u - arr[j];
                if (Arrays.binarySearch(sum, target) >= 0) {
                    System.out.println(u);
                    return;
                }
            }
        }
    }
}
