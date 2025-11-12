import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sizeA = Integer.parseInt(st.nextToken());
            int sizeB = Integer.parseInt(st.nextToken());

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < sizeA; i++) {
                setA.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < sizeB; i++) {
                setB.add(Integer.parseInt(st.nextToken()));
            }

            if (setA.equals(setB)) {
                sb.append("=\n");
            } else if (setB.containsAll(setA)) {
                sb.append("<\n");
            } else if (setA.containsAll(setB)) {
                sb.append(">\n");
            } else {
                sb.append("?\n");
            }
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}
