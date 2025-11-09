import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            boolean[] nums = new boolean[10];
            int count = 0;
            int origin = n;

            while (true) {
                String num = String.valueOf(n);

                for (int i = 0; i < num.length(); i++) {
                    int digit = num.charAt(i) - '0';
                    nums[digit] = true;
                }

                count++;
                n += origin;

                boolean allSeen = true;
                for (boolean b: nums) {
                    if (!b) {
                        allSeen = false;
                        break;
                    }
                }

                if (allSeen) break;
            }

            sb.append("#").append(t).append(" ").append(n - origin).append("\n");
        }

        sb.setLength(sb.length() -1);
        System.out.print(sb);
    }
}
