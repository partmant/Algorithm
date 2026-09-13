import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] isOpened = new boolean[cards.length];
        List<Integer> scores = new ArrayList<>();
        
        for (int i = 0; i < cards.length; i++) {
            if (isOpened[i]) continue;
            
            int cnt = 0;
            int next = i;
            
            while (!isOpened[next]) {
                isOpened[next] = true;
                next = cards[next] - 1; 
                cnt++;
            }
            
            scores.add(cnt);
        }
        
        if (scores.size() < 2) return 0;
        
        scores.sort(Collections.reverseOrder());
        return scores.get(0) * scores.get(1);
    }
}