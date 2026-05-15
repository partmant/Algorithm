import java.util.Stack;

class Solution {
	public int[] solution(int[] numbers) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[numbers.length];

		for (int i = numbers.length - 1; i >= 0; i--) {
			int num = numbers[i];

			while (!stack.isEmpty() && num >= stack.peek()) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}

			stack.push(num);
		}

		return result;
	}
}
