import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();

            for (int number = 1; number <= N; number++) {
                String numberStr = String.valueOf(number);
                int clapCount = 0;

                for (int j = 0; j < numberStr.length(); j++) {
                    int digit = numberStr.charAt(j) - '0';
                    if (digit != 0 && digit % 3 == 0) {
                        clapCount++;
                    }
                }

                if (clapCount > 0) {
                    for (int k = 0; k < clapCount; k++) {
                        sb.append("-");
                    }
                } else {
                    sb.append(number);
                }

                sb.append(" ");
            }

            System.out.print(sb.toString().trim());
        }
    }
}
