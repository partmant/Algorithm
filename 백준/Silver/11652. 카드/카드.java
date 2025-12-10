import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> freq = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(freq.entrySet());

        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue();
            }
            return Long.compare(a.getKey(), b.getKey());
        });

        System.out.println(list.get(0).getKey());
    }
}
