import java.util.*;

class Solution {
    private int maxDiff = 0;
    private int[] ryan = new int[11];     // 현재 라이언의 화살 배치
    private int[] answer = {-1};

    public int[] solution(int n, int[] info) {
        dfs(0, n, info);
        return answer;
    }

    private void dfs(int depth, int remainArrow, int[] info) {
        if (depth == 11) {
            if (remainArrow > 0) { // 남은 화살이 있다면 모두 0점에 몰아쏘기
                ryan[10] += remainArrow;
            }

            calculateScore(info);

            if (remainArrow > 0) { // 몰아쏜 화살 원복
                ryan[10] -= remainArrow;
            }
            return;
        }

        // 1. 해당 점수 얻기
        int needArrow = info[depth] + 1;
        if (remainArrow >= needArrow) {
            ryan[depth] = needArrow;
            dfs(depth + 1, remainArrow - needArrow, info);
            ryan[depth] = 0;
        }

        // 2. 해당 점수 포기하기
        dfs(depth + 1, remainArrow, info);
    }

    private void calculateScore(int[] info) {
        int apeachScore = 0, ryanScore = 0;

        for (int i = 0; i < 11; i++) {
            if (ryan[i] == 0 && info[i] == 0) continue;

            if (ryan[i] > info[i]) {
                ryanScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }

        int diff = ryanScore - apeachScore;

        // 라이언이 이긴 경우
        if (diff > 0) {
            if (diff > maxDiff) {
                maxDiff = diff;
                answer = ryan.clone();
            } else if (diff == maxDiff && isBetter()) {
                answer = ryan.clone();
            }
        }
    }

    // 동점인 경우 가장 낮은 점수를 더 많이 맞혔는지 검사
    private boolean isBetter() {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] != answer[i]) {
                return ryan[i] > answer[i];
            }
        }
        return false;
    }
}