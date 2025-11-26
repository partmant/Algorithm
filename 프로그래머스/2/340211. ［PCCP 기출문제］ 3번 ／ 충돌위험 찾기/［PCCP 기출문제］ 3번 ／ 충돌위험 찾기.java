import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int robotCount = routes.length;

        Map<Integer, Map<String, Integer>> timeMap = new HashMap<>();

        int maxTime = 0;

        for (int i = 0; i < robotCount; i++) {
            int time = 0;
            int[] start = null;

            for (int j = 0; j < routes[i].length; j++) {
                int idx = routes[i][j] - 1;
                int[] target = points[idx];

                if (j == 0) {
                    start = target;
                    mark(timeMap, time, start[0], start[1]);
                    continue;
                }

                // 이전 포인트 → 현재 target 으로 이동
                int sr = start[0];
                int sc = start[1];
                int tr = target[0];
                int tc = target[1];

                while (sr != tr) {
                    time++;
                    sr += (tr > sr ? 1 : -1);
                    mark(timeMap, time, sr, sc);
                }
                while (sc != tc) {
                    time++;
                    sc += (tc > sc ? 1 : -1);
                    mark(timeMap, time, sr, sc);
                }

                start = target;
            }

            maxTime = Math.max(maxTime, time);
        }

        // 충돌 위험 계산
        int answer = 0;
        for (int t = 0; t <= maxTime; t++) {
            Map<String, Integer> m = timeMap.get(t);
            if (m == null) continue;
            for (int count : m.values()) {
                if (count >= 2) answer++;
            }
        }

        return answer;
    }

    private void mark(Map<Integer, Map<String, Integer>> map, int time, int r, int c) {
        map.putIfAbsent(time, new HashMap<>());
        Map<String, Integer> inner = map.get(time);
        String key = r + "," + c;
        inner.put(key, inner.getOrDefault(key, 0) + 1);
    }
}
