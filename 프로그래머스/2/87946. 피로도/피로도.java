class Solution {
    
    private boolean[] visited;
    private int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        explore(k, 0, dungeons);
        return answer;
    }
    
    private void explore(int fatigue, int depth, int[][] dungeons) {
        answer = Math.max(answer, depth);
        
        for (int idx = 0; idx < dungeons.length; idx++) {
            if (!visited[idx] && fatigue >= dungeons[idx][0]) {
                visited[idx] = true;
                explore(fatigue - dungeons[idx][1], depth + 1, dungeons);
                visited[idx] = false;
            }
        }
    }
}