import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int first = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            pq.add(sc.nextInt());
        }

        int buy = 0;
        while(!pq.isEmpty() && first <= pq.peek()) {
            pq.add(pq.poll() - 1);
            first++;
            buy++;
        }
        
        System.out.println(buy);
    }
}
