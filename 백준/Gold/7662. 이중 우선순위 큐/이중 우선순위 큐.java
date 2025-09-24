import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (type.equals("I"))
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    
                else if (type.equals("D")) {
                    if (map.isEmpty()) continue;

                    if (num == 1) {
                        int maxKey = map.lastKey();
                        
                        if (map.put(maxKey, map.get(maxKey) - 1) == 1)
                            map.remove(maxKey);
                        
                    } else {
                        int minKey = map.firstKey();
                        
                        if (map.put(minKey, map.get(minKey) - 1) == 1) 
                            map.remove(minKey);
                    }
                }
            }

            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        bw.flush();
    }
}