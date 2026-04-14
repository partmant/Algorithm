import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] dp = new int[N];
        int max = 0;

        for (int i = 1; i < N; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i >= 2) {
                        dp[i] += dp[i - 2];
                    }
                }
                else {
                    int prev = dp[i - 1];
                    int openIdx = i - prev - 1;

                    if (openIdx >= 0 && s.charAt(openIdx) == '(') {
                        dp[i] = prev + 2;
                        if (openIdx - 1 >= 0) {
                            dp[i] += dp[openIdx - 1];
                        }
                    }
                }

                max = Math.max(max, dp[i]);
            }
        }

        System.out.println(max);
    }
}
