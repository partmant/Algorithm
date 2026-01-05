import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Deque<Character> dq = new ArrayDeque<>();

        dq.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= dq.peekFirst()) {
                dq.addFirst(c);
            } else {
                dq.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : dq) {
            sb.append(c);
        }

        System.out.print(sb.toString());
    }
}
