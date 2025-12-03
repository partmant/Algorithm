import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> freq = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String title = sc.next();
            freq.put(title, freq.getOrDefault(title, 0) + 1);
        }
        
        String answer = "";
        int maxCount = 0;

        for (String key : freq.keySet()) {
            int cnt = freq.get(key);
            if (cnt > maxCount || (cnt == maxCount && key.compareTo(answer) < 0)) {
                maxCount = cnt;
                answer = key;
            }
        }

        System.out.println(answer);
    }
}
