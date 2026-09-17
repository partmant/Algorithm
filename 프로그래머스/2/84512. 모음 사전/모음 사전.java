import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = word.length();
        
        String vowels = "AEIOU";
        
        int[] rate = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {
            int idx = vowels.indexOf(word.charAt(i));
            answer += rate[i] * idx;
        }

        return answer;
    }
}