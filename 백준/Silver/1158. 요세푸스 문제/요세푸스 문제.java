import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        
        int index = 1;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            if (index % k == 0) {
                sj.add(String.valueOf(now));
            } else {
                q.add(now);
            }
            index++;
        }
        
        System.out.print(sj);
    }
}
