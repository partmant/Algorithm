import java.io.*;
import java.util.*;

class Main {

    static class Edge {
        int x;
        int h;

        Edge(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            edges.add(new Edge(s, -h));
            edges.add(new Edge(e, h));
        }

        edges.sort((a, b) -> {
            if (a.x != b.x) return a.x - b.x;
            return a.h - b.h;
        });

        TreeMap<Integer, Integer> heights =
                new TreeMap<>(Collections.reverseOrder());
        heights.put(0, 1);

        int prevMax = 0;
        StringBuilder sb = new StringBuilder();

        for (Edge edge : edges) {
            int x = edge.x;
            int h = edge.h;

            if (h < 0) {
                heights.put(-h, heights.getOrDefault(-h, 0) + 1);
            } else {
                if (heights.get(h) == 1) {
                    heights.remove(h);
                } else {
                    heights.put(h, heights.get(h) - 1);
                }
            }

            int currMax = heights.firstKey();

            if (currMax != prevMax) {
                sb.append(x).append(" ").append(currMax).append(" ");
                prevMax = currMax;
            }
        }

        System.out.print(sb.toString());
    }
}
