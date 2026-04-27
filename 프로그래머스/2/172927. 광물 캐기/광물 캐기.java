import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPickCount = picks[0] + picks[1] + picks[2];
        int maxMineralCount = Math.min(minerals.length, totalPickCount * 5);

        List<int[]> groups = new ArrayList<>();

        for (int i = 0; i < maxMineralCount; i += 5) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5 && j < maxMineralCount; j++) {
                if (minerals[j].equals("diamond")) {
                    diamond++;
                } else if (minerals[j].equals("iron")) {
                    iron++;
                } else {
                    stone++;
                }
            }

            groups.add(new int[] { diamond, iron, stone });
        }

        groups.sort((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }

            if (a[1] != b[1]) {
                return b[1] - a[1];
            }

            return b[2] - a[2];
        });

        for (int[] group : groups) {
            int diamond = group[0];
            int iron = group[1];
            int stone = group[2];

            if (picks[0] > 0) {
                answer += diamond + iron + stone;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += diamond * 5 + iron + stone;
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += diamond * 25 + iron * 5 + stone;
                picks[2]--;
            }
        }

        return answer;
    }
}
