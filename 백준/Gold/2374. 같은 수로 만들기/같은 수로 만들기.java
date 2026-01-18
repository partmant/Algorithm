import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if(max < value) max = value;

            if (!stack.isEmpty()) {
                int top = stack.pop();
                if (top <= value) answer += value - top;
            }
            stack.push(value);
        }
        answer += max - stack.pop();
        System.out.println(answer);
    }
}
