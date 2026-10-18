import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0; // 지금까지 소모한 총 병사 수
        
        for (int i = 0; i < enemy.length; i++) {
            int cur = enemy[i];
            
            sum += cur;
            pq.offer(cur);
            
            if (sum > n) {
                if (k > 0) {
                    sum -= pq.poll();
                    k--;
                } else {
                    return i;
                }
            }
        }
        
        return enemy.length;
    }
}