import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A); // 배열 정렬

        for (int k = 0; k < N; k++) {
            int i = 0;
            int j = N - 1;

            while (i < j) {
                if (i == k) { 
                    i++; 
                    continue; 
                }
                if (j == k) { 
                    j--; 
                    continue; 
                }

                long sum = A[i] + A[j];
                if (sum == A[k]) { // 두 수의 합이 A[k]와 같은 경우
                    R++;
                    break;
                } else if (sum < A[k]) { // 합이 A[k]보다 작으면 i 증가
                    i++;
                } else { // 합이 A[k]보다 크면 j 감소
                    j--;
                }
            }
        }
        System.out.println(R);
        br.close();
    }
}
