import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<String[]> q = new LinkedList<>();
        q.offer(new String[]{begin, "0"});

        while (!q.isEmpty()) {
            String[] current = q.poll();
            String word = current[0];
            int step = Integer.parseInt(current[1]);

            if (word.equals(target)) {
                return step;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isChangeable(word, words[i])) {
                    visited[i] = true;
                    q.offer(new String[]{words[i], String.valueOf(step + 1)});
                }
            }
        }

        return 0;
    }

    private boolean isChangeable(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (++diff > 1) return false;
            }
        }
        return diff == 1;
    }
}
