import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for (int num : queue1) {
            q1.add(num);
            sum1 += num;
        }
        for (int num : queue2) {
            q2.add(num);
            sum2 += num;
        }
        
        // 총합이 홀수이면 불가능
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        long target = (sum1 + sum2) / 2;
        int cnt = 0;
        
        // 원소가 원위치로 돌아오는 최대 이동 횟수
        int maxOp = queue1.length * 4; 
        
        while (sum1 != target) {
            if (cnt > maxOp) return -1;
            
            if (sum1 > target) {
                int value = q1.poll();
                q2.add(value);
                sum1 -= value;
                sum2 += value;
            } else {
                int value = q2.poll();
                q1.add(value);
                sum1 += value;
                sum2 -= value;
            }
            cnt++;
        }
        
        return cnt;
    }
}