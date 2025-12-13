import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Integer> order = new HashMap<>();
        for (int i = 0; i < n; i++) {
            order.put(sc.next(), i);
        }

        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            out[i] = order.get(sc.next());
        }

        int count = 0;
        int minSuffix = out[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            if (out[i] > minSuffix) {
                count++;
            } else {
                minSuffix = out[i];
            }
        }

        System.out.println(count);
    }
}
