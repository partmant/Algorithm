import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();

            if (map.containsKey(id)) {
                map.remove(id);
            }
            map.put(id, 1);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String id : map.keySet()) {
            if (count++ == K) break;
            sb.append(id).append('\n');
        }

        System.out.print(sb);
    }
}
