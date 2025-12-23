import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        
        for (int i = 0; i < line.length(); i++) {
            char text = line.charAt(i);
            
            if (text == '(') {
                int k = line.charAt(i - 1) - '0';
                stack.push(len - 1);
                stack.push(k);
                len = 0;
            } else if (text == ')') {
                int k = stack.pop(); 
                int preLen = stack.pop();
                len = preLen + len * k;
            } else {
                len++;
            }
        }
        
        System.out.println(len);
    }
}
