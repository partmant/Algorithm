import java.util.*;

public class Main {

    static Map<Long, String> map = new HashMap<>();
    static Queue<Long> q = new ArrayDeque<>();
    static long target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        target = sc.nextLong();
        
        if (start == target) {
            System.out.println(0);
            return;
        }

        map.put(start, "");
        q.add(start);

        while (!q.isEmpty()) {
            long n = q.poll();
            String cur = map.get(n);

            if (n == target) {
                System.out.println(cur);
                return;
            }

            calc(n, n * n, '*');
            calc(n, n + n, '+');
            calc(n, 0, '-');
            if (n != 0) calc(n, 1, '/');
        }

        System.out.println(-1);
    }

    static void calc(long from, long to, char op) {
        if (map.containsKey(to)) return;

        map.put(to, map.get(from) + op);
        q.add(to);
    }
}
