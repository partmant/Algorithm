import java.io.*;
import java.util.*;

public class Main {

    public static int priority(char op) {
        if (op == '(') return 0;
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && priority(st.peek()) >= priority(c)) {
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        System.out.println(sb);
    }
}
