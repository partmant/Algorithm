import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long sum = 0;
        long answer = 0;

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        for (int i = 1; i <= N; i++) {
            long a = Long.parseLong(st.nextToken());
            sum += a;

            long key = sum - K * i;

            answer += map.getOrDefault(key, 0L);
            map.put(key, map.getOrDefault(key, 0L) + 1);
        }

        System.out.println(answer);
    }
}
