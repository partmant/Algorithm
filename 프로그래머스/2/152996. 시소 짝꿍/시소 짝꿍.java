import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Long> map = new HashMap<>();
        long answer = 0;

        Arrays.sort(weights);

        for (int weight : weights) {
            answer += map.getOrDefault(weight, 0L);

            if (weight * 2 % 3 == 0) {
                answer += map.getOrDefault(weight * 2 / 3, 0L);
            }

            if (weight % 2 == 0) {
                answer += map.getOrDefault(weight / 2, 0L);
            }

            if (weight * 3 % 4 == 0) {
                answer += map.getOrDefault(weight * 3 / 4, 0L);
            }

            map.put(weight, map.getOrDefault(weight, 0L) + 1);
        }

        return answer;
    }
}
