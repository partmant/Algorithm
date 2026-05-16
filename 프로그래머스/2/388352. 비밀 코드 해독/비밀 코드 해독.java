import java.util.HashSet;
import java.util.Set;

class Solution {
	private static int maxNum;
	private static int[][] queries;
	private static int[] answers;

	public int solution(int n, int[][] q, int[] ans) {
		maxNum = n;
		queries = q;
		answers = ans;
		Set<Integer> set = new HashSet<>();

		return dfs(1, 0, set);
	}

	private int dfs(int start, int depth, Set<Integer> selected) {
		if (depth == 5) {
			return isValid(selected);
		}
		
		if (maxNum - start + 1 < 5 - depth) {
		    return 0;
		}

		int cnt = 0;
		for (int i = start; i <= maxNum; i++) {
			selected.add(i);
			cnt += dfs(i + 1, depth + 1, selected);
			selected.remove(i);
		}

		return cnt;
	}

	private int isValid(Set<Integer> pw) {
		for (int i = 0; i < queries.length; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (pw.contains(queries[i][j]))
					cnt++;
			}
			if (cnt != answers[i])
				return 0;
		}
		return 1;
	}
}
