import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        
        
        int cnt = 0;
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }
            pq.offer(pq.poll() + pq.poll() * 2);
            cnt++;
        }
        
        return cnt;
    }
}