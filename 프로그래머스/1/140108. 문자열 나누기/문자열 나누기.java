class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;

        while (index < s.length()) {
            char target = s.charAt(index);
            int targetCnt = 0;
            int otherCnt = 0;

            while (index < s.length()) {
                if (s.charAt(index) == target) {
                    targetCnt++;
                } else {
                    otherCnt++;
                }
                index++;

                if (targetCnt == otherCnt) {
                    break;
                }
            }

            answer++;
        }

        return answer;
    }
}
