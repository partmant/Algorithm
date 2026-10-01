import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        for (String line : info) {
            String[] parsed = line.split(" ");
            String[] conditions = Arrays.copyOfRange(parsed, 0, 4);
            int score = Integer.parseInt(parsed[4]);
            
            makeCombinations(conditions, "", 0, score);
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] parsed = query[i].split("(and| )+");
            
            StringBuilder keyBuilder = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                keyBuilder.append(parsed[j]);
            }
            String key = keyBuilder.toString();
            int targetScore = Integer.parseInt(parsed[4]);

            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
                int start = lowerBound(list, targetScore);
                answer[i] = list.size() - start;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    // 16가지 키 조합을 만드는 메서드
    private void makeCombinations(String[] conditions, String currentKey, int depth, int score) {
        if (depth == 4) {
            map.computeIfAbsent(currentKey, k -> new ArrayList<>()).add(score);
            return;
        }
        
        makeCombinations(conditions, currentKey + conditions[depth], depth + 1, score);
        makeCombinations(conditions, currentKey + "-", depth + 1, score);
    }

    // 이분 탐색으로 targetScore 이상이 처음 나오는 인덱스 반환하는 메서드
    private int lowerBound(List<Integer> list, int targetScore) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= targetScore) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}