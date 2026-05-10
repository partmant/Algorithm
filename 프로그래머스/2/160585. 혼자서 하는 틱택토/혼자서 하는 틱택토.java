class Solution {
	public int solution(String[] board) {
		int oCnt = 0;
		int xCnt = 0;

		for (String row : board) {
			for (char c : row.toCharArray()) {
				if (c == 'O') {
					oCnt++;
				} else if (c == 'X') {
					xCnt++;
				}
			}
		}

		boolean oWin = isWin(board, 'O');
		boolean xWin = isWin(board, 'X');

		if (!(oCnt == xCnt || oCnt == xCnt + 1)) {
			return 0;
		}

		if (oWin && xWin) {
			return 0;
		}

		if (oWin && oCnt != xCnt + 1) {
			return 0;
		}

		if (xWin && oCnt != xCnt) {
			return 0;
		}

		return 1;
	}

	private boolean isWin(String[] board, char target) {
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target) {
				return true;
			}
		}

		for (int j = 0; j < 3; j++) {
			if (board[0].charAt(j) == target && board[1].charAt(j) == target && board[2].charAt(j) == target) {
				return true;
			}
		}

		if (board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target) {
			return true;
		}

		if (board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target) {
			return true;
		}

		return false;
	}
}
