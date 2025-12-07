import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String expr = br.readLine();

        double[] values = new double[N];
        for (int i = 0; i < N; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {

            if ('A' <= ch && ch <= 'Z') {
                stack.push(values[ch - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();
                double result = 0;

                switch (ch) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                }
                stack.push(result);
            }
        }

        System.out.printf("%.2f\n", stack.pop());
    }
}
