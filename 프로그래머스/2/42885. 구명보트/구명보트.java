import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int lIdx = 0;
        int rIdx = people.length - 1;
        int answer = 0;
        
        while (lIdx <= rIdx) {
            if (people[lIdx] + people[rIdx] <= limit) {
                lIdx++;
            }
                
            rIdx--;
            answer++;
        }
        
        return answer;
    }
}