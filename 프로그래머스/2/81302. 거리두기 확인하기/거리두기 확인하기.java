import java.util.*;

class Solution {
    
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    
    public int[] solution(String[][] places) {
        List<Integer> answerList = new ArrayList<>();
        
        for (String[] place : places) {
            answerList.add(checkPlace(place));
        }
        
        return answerList.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    private int checkPlace(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!isKeepDistance(place, r, c)) {
                        return 0;
                    }
                }
            }
        }
        
        return 1;
    }
    
    private boolean isKeepDistance(String[] place, int r, int c) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{r, c, 0});
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[2] == 2) continue;
            
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                if (visited[nr][nc] || place[nr].charAt(nc) == 'X') continue;
                
                // 거리 2 이하에서 사람을 만난 경우
                if (place[nr].charAt(nc) == 'P') return false; 
                
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, cur[2] + 1});
            }
        }
        
        return true;
    }
}