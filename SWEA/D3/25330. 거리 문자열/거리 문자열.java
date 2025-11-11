import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            String s = sc.next();
            int[] visited = new int[10];
            int[] first = new int[10];
            Arrays.fill(first, -1);
            boolean result = true;

            int[] nums = new int[s.length()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = s.charAt(i) - '0';
            }

            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                visited[n]++;

                if (visited[n] == 1) {
                    first[n] = i;
                } else if (visited[n] == 2) {
                    int distance = i - first[n] - 1;
                    if (distance != n) {
                        result = false;
                        break;
                    }
                } else {
                    result = false;
                    break;
                }
            }

            if (result) {
                for (int v : visited) {
                    if (v != 0 && v != 2) {
                        result = false;
                        break;
                    }
                }
            }

            sb.append(result ? "yes" : "no").append('\n');
        }

        System.out.print(sb);
    }
}
