import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(sc.nextInt());
            }

            int max = Collections.max(list);
            int min = Collections.min(list);

            list.remove((Integer) max);
            list.remove((Integer) min);
            
            double sum = 0;
            for (int num : list) {
                sum += num;
            }

            long avg = Math.round(sum / list.size());
            sb.append("#").append(t).append(" ").append(avg).append("\n");
        }

        System.out.print(sb.toString());
    }
}