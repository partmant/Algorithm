import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'H') stack.push(1);
            else if (c == 'C') stack.push(12);
            else if (c == 'O') stack.push(16);

            else if (c == '(') stack.push(-1);

            else if (c == ')') {
                int sum = 0;
                while (stack.peek() != -1) {
                    sum += stack.pop();
                }
                stack.pop();
                stack.push(sum);
            }

            else {
                int num = c - '0';
                stack.push(stack.pop() * num);
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
