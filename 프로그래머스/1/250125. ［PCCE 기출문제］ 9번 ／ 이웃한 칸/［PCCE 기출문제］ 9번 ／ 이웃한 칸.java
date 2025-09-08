class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int answer = 0;
        for(int i = 0; i < 4; i++) {
            int nh = h + dr[i];
            int nw = w + dc[i];
            if(nh >= 0 && nh < board.length && nw >= 0 && nw < board[0].length) {
                if(board[nh][nw].equals(board[h][w])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}