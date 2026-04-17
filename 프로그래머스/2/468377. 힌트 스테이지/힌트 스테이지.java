class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int n = cost.length;
        int answer = Integer.MAX_VALUE;
        int totalMask = 1 << (n - 1);

        for (int mask = 0; mask < totalMask; mask++) {
            int[] hintCnt = new int[n];
            int totalCost = 0;

            for (int stage = 0; stage < n; stage++) {
                int used = Math.min(hintCnt[stage], n - 1);
                totalCost += cost[stage][used];

                if (stage < n - 1 && ((mask & (1 << stage)) != 0)) {
                    totalCost += hint[stage][0];

                    for (int j = 1; j < hint[stage].length; j++) {
                        int targetStage = hint[stage][j] - 1;
                        hintCnt[targetStage]++;
                    }
                }
            }

            answer = Math.min(answer, totalCost);
        }

        return answer;
    }
}