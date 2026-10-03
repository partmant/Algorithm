import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
        for (int[] query : queries) {
            answerList.add(rotate(matrix, query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1));
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int rotate(int[][] matrix, int sr, int sc, int er, int ec) {
        int temp = matrix[sr][sc];
        int min = temp;
        
        // 1. 왼쪽 변 (아래 -> 위)
        for (int i = sr; i < er; i++) {
            matrix[i][sc] = matrix[i + 1][sc];
            min = Math.min(min, matrix[i][sc]);
        }
        
        // 2. 아래쪽 변 (오른쪽 -> 왼쪽)
        for (int i = sc; i < ec; i++) {
            matrix[er][i] = matrix[er][i + 1];
            min = Math.min(min, matrix[er][i]);
        }
        
        // 3. 오른쪽 변 (위 -> 아래)
        for (int i = er; i > sr; i--) {
            matrix[i][ec] = matrix[i - 1][ec];
            min = Math.min(min, matrix[i][ec]);
        }
        
        // 4. 위쪽 변 (왼쪽 -> 오른쪽)
        for (int i = ec; i > sc + 1; i--) {
            matrix[sr][i] = matrix[sr][i - 1];
            min = Math.min(min, matrix[sr][i]);
        }
        
        // 빼두었던 temp 대입
        matrix[sr][sc + 1] = temp;
        
        return min;
    }
}