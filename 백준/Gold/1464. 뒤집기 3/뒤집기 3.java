import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String S = sc.next();
        Deque<Character> q = new ArrayDeque<>();
        
        for (int i = 0; i < S.length(); i++) {
            q.add(S.charAt(i));
        }        
         
        char first = q.poll();
        StringBuilder sb = new StringBuilder();
        sb.append(first);

        while (!q.isEmpty()) {
            char last = q.poll();
            if (last <= first) {
                sb.insert(0, last);
                first = last;
            } else {
            	sb.append(last);
            }
        }
        
        System.out.print(sb);
    }
}
