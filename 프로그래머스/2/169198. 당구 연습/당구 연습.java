class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
    	int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
        	int targetX = balls[i][0];
        	int targetY = balls[i][1];
        	
        	int min = Integer.MAX_VALUE;

        	// 왼쪽
        	if (!(startY == targetY && startX > targetX)) {
                min = Math.min(min, getDistance(startX, startY, -targetX, targetY));
            }

            // 오른쪽
            if (!(startY == targetY && startX < targetX)) {
                min = Math.min(min, getDistance(startX, startY, 2 * m - targetX, targetY));
            }

            // 아래쪽
            if (!(startX == targetX && startY > targetY)) {
                min = Math.min(min, getDistance(startX, startY, targetX, -targetY));
            }

            // 위쪽
            if (!(startX == targetX && startY < targetY)) {
                min = Math.min(min, getDistance(startX, startY, targetX, 2 * n - targetY));
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
    
    private int getDistance(int startX, int startY, int targetX, int targetY) {
    	return  (int) (Math.pow(startX - targetX, 2) + Math.pow(startY - targetY, 2));
    }
}
