class Solution {
    public int solution(int[][] signals) {
        int maxTime = 1;
        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            maxTime *= cycle;
        }

        for (int t = 1; t <= maxTime; t++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                int g = signal[0];
                int y = signal[1];
                int r = signal[2];
                int cycle = g + y + r;

                int timeInCycle = (t - 1) % cycle;

                if (!(timeInCycle >= g && timeInCycle < g + y)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return t;
            }
        }

        return -1;
    }
}
