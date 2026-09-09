import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int target = 0;

        for (int box = 1; box <= order.length; box++) {
            sub.push(box);
            
            while (!sub.isEmpty() && sub.peek() == order[target]) {
                sub.pop();
                target++;
            }
            
            if (target < order.length && box > order[target]) break;
        }

        return target;
    }
}