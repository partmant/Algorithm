class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            
            // 짝수인 경우: 가장 끝 비트가 0이므로 +1만 해주면 됨
            if (x % 2 == 0) {
                answer[i] = x + 1;
            } 
            // 홀수인 경우
            else {
                long diffMask = x ^ (x + 1); // 가장 오른쪽 0부터 끝까지 1로 채운 마스크
                long diffValue = (diffMask + 1) >> 2; // 실제 더할 값 계산
                
                answer[i] = x + diffValue;
            }
        }
        
        return answer;
    }
}