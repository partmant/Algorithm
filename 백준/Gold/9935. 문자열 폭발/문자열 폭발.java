import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String input = br.readLine();    
        String bomb = br.readLine();

        int bombLen = bomb.length();
        char bombLast = bomb.charAt(bombLen - 1);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.push(ch);

            if (stack.size() >= bombLen && stack.peek() == bombLast) {
                boolean isBomb = true;
                
                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) 
                    for (int j = 0; j < bombLen; j++) 
                        stack.pop();
            }
        }

        for (char c : stack)
            sb.append(c);

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}