class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 0;

        for (int diff : diffs) {
            right = Math.max(right, diff);
        }

        int maxLevel = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossibleLevel(diffs, times, limit, mid)) {
                maxLevel = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return maxLevel;
    }

    private boolean isPossibleLevel(int[] diffs, int[] times, long limit, int level) {
        long total = times[0];

        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                long failCount = diffs[i] - level;
                total += failCount * (times[i - 1] + times[i]) + times[i];
            }

            if (total > limit) {
                return false;
            }
        }

        return total <= limit;
    }
}
