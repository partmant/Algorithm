import java.util.*;

class Solution {
    public List solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            days[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }

        int now = days[0];
        int count = 1;
        for (int i = 1; i < days.length; i++) {
            if (days[i] <= now) {
                count++;
            } else {
                result.add(count);
                count = 1;
                now = days[i];
            }
        }
        result.add(count);

        return result;
    }
}
