import java.util.*;

class Solution {

    static int n;
    static double maxWinRate;
    static List<Integer> bestDice;

    public int[] solution(int[][] dice) {
        n = dice.length;
        maxWinRate = 0;
        bestDice = new ArrayList<>();

        List<Integer> current = new ArrayList<>();
        combination(0, 0, n / 2, current, dice);

        return bestDice.stream().mapToInt(i -> i+1).toArray();
    }

    private static void combination(int start, int depth, int r, List<Integer> current, int[][] dice) {
        if (depth == r) {
            List<Integer> aList = new ArrayList<>(current);
            List<Integer> bList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!aList.contains(i)) bList.add(i);
            }

            double winRate = calculateWinRate(aList, bList, dice);
            if (winRate > maxWinRate) {
                maxWinRate = winRate;
                bestDice = new ArrayList<>(aList);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            current.add(i);
            combination(i + 1, depth + 1, r, current, dice);
            current.remove(current.size() - 1);
        }
    }

    private static Map<Integer, Integer> getSum(List<Integer> dices, int[][] dice) {
        Map<Integer, Integer> sumSet = new HashMap<>();
        sumSet.put(0, 1);

        for (int i : dices) {
            Map<Integer, Integer> newSumSet = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : sumSet.entrySet()) {
                int preSum = entry.getKey();
                int preFre = entry.getValue();
                for (int j : dice[i]) {
                    int newSum = preSum + j;
                    newSumSet.put(newSum, newSumSet.getOrDefault(newSum, 0) + preFre);
                }
            }
            sumSet = newSumSet;
        }
        return sumSet;
    }

    private static double calculateWinRate(List<Integer> aList, List<Integer> bList, int[][] dice) {
        Map<Integer, Integer> aSums = getSum(aList, dice);
        Map<Integer, Integer> bSums = getSum(bList, dice);

        List<Integer> bKeys = new ArrayList<>(bSums.keySet());
        Collections.sort(bKeys);

        Map<Integer, Integer> bPrefix = new HashMap<>();
        int cumulative = 0;
        for (int b : bKeys) {
            cumulative += bSums.get(b);
            bPrefix.put(b, cumulative);
        }

        long winCount = 0;
        long totalCount = 0;

        for (Map.Entry<Integer, Integer> aEntry : aSums.entrySet()) {
            int aSum = aEntry.getKey();
            int aFreq = aEntry.getValue();

            int bFreqSmaller = 0;
            for (int b : bKeys) {
                if (b < aSum) bFreqSmaller = bPrefix.get(b);
                else break;
            }
            winCount += (long) aFreq * bFreqSmaller;
        }

        for (int aFreq : aSums.values())
            for (int bFreq : bSums.values())
                totalCount += (long) aFreq * bFreq;

        return (double) winCount / totalCount;
    }
}