import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        boolean inTag = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                inTag = true;
                sb.append(c);
            } 
            else if (c == '>') {
                inTag = false;
                sb.append(c);
            } 
            else if (inTag) {
                sb.append(c);
            } 
            else {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
