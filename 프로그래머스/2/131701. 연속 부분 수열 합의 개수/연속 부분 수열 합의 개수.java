import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sum = new HashSet<>();
        int[] subSum = new int[elements.length];
        
        for (int subLen = 1; subLen <= elements.length; subLen++) {
            for (int idx = 0; idx < elements.length; idx++) { // idx부터 부분 수열 길이까지의 합
                subSum[idx] += elements[(idx + subLen - 1) % elements.length];
                sum.add(subSum[idx]);
                
                if (subLen == elements.length) break;
            }
        }
            
        return sum.size();
    }
}