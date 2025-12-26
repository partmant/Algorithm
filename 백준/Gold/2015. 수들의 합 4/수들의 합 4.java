import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        long sum = 0;
        long answer = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(st.nextToken());
            sum += x;

            answer += map.getOrDefault(sum - K, 0L);

            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }

        System.out.print(answer);
    }
}
