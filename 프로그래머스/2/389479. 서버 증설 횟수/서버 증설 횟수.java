import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] players, int m, int k) {
		Queue<int[]> q = new LinkedList<>();
		int serverCnt = 0;
		int result = 0;
		
		for (int i = 0; i < 24; i++) {
			while (!q.isEmpty() && q.peek()[0] == i) {
                serverCnt -= q.poll()[1];
            }
			
			int playerCnt = players[i];
			int required = playerCnt / m;
			
			if (serverCnt < required) {
				q.add(new int[] {i + k, required - serverCnt});
				result += required - serverCnt;
				serverCnt = required;
			}
			
		}

		return result;

	}
}
