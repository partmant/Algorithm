class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        long sum = sequence[0];

        int bestL = 0;
        int bestR = sequence.length - 1;
        int minLen = Integer.MAX_VALUE;

        while (left <= right && right < sequence.length) {
            if (sum == k) {
                int len = right - left;
                if (len < minLen) {
                    minLen = len;
                    bestL = left;
                    bestR = right;
                }

                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left];
                left++;
            }
        }

        return new int[] { bestL, bestR };
    }
}