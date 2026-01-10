import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] len = new int[N];
        for (int i = 0; i < N; i++) {
            len[i] = br.readLine().length();
        }

        long answer = 0;
        int[] count = new int[21];

        for (int i = 0; i < N; i++) {
            answer += count[len[i]];

            count[len[i]]++;

            if (i - K >= 0) {
                count[len[i - K]]--;
            }
        }

        System.out.print(answer);
    }
}
