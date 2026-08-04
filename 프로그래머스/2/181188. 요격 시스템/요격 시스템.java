import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int answer = 0;
        int last = -1;
        
        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];
            
            if (s >= last) {
                answer++;
                last = e;
            }
        }
       
        return answer;
    }
}
