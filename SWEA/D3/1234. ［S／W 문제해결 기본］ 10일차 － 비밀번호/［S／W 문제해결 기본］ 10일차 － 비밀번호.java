import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++) {
            Stack<Integer> stack = new Stack<>();
            int N = sc.nextInt();
            String password = sc.next();
            
            for (int i = 0; i < N; i++) {
            	int num = password.charAt(i) - '0';
                if (stack.isEmpty()) {
                	stack.push(num);
                } else {
                	int pre = stack.peek();
                    if (pre == num) {
                    	stack.pop();
                    } else {
                    	stack.push(num);
                    }
                }
            }
            
            ArrayList<Integer> result = new ArrayList<>();
            while (!stack.isEmpty()) {
                result.add(stack.pop());
            }
            
            Collections.reverse(result);
            
            sb.append("#").append(test_case).append(" ");
			for (int num : result) {
            	sb.append(num);
            }
            if (test_case != 10) {
            	sb.append("\n");
            }
		}
        
        System.out.print(sb);
	}
}