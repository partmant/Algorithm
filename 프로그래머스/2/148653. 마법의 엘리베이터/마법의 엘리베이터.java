class Solution {
    public int solution(int storey) {
        String s = String.valueOf(storey);
        int answer = 0;
        int carry = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - '0' + carry;

            if (num > 5) {
                answer += 10 - num;
                carry = 1;
            } else if (num == 5) {
                int prevDigit = (i > 0) ? (s.charAt(i - 1) - '0') : 0;
                if (prevDigit >= 5) {
                    answer += 5;
                    carry = 1;
                } else {
                    answer += 5;
                    carry = 0;
                }
            } else {
                answer += num;
                carry = 0;
            }
        }
        answer += carry;

        return answer;
    }
}