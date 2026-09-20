import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            
            answer[i] = (lastPos[ch] == -1) ? -1 : i - lastPos[ch];
            lastPos[ch] = i;
        }
        
        return answer;
    }
}