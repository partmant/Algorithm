import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new LinkedHashMap<>();
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            freq.put(x, freq.getOrDefault(x, 0) + 1);
            first.putIfAbsent(x, i);
        }
        
        List<Integer> nums = new ArrayList<>(freq.keySet());
        
        Collections.sort(nums, (a, b) -> {
            int fa = freq.get(a);
            int fb = freq.get(b);

            if (fa != fb) return fb - fa;
            return first.get(a) - first.get(b);
        });
        
        StringBuilder sb = new StringBuilder();

        for (int num : nums) {
            int count = freq.get(num);
            for (int i = 0; i < count; i++) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
