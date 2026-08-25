class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        if (m == 1) {
            return section.length;
        }
        
        int lastIdx = 0;
        for (int s : section) {
            if (lastIdx >= s) continue;
            
            answer++;
            
            if (s + m - 1 <= n) {
                lastIdx = s + m - 1;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
