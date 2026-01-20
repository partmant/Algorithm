import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int leafIdx = 1;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        while (leafIdx < N) leafIdx <<= 1;

        tree = new long[leafIdx << 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                update(v1, v2);
            } else {
                sb.append(query(1, 1, leafIdx, v1, v2)).append('\n');
            }
        }
        System.out.print(sb);
    }

    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) >> 1;
        return query(node << 1, start, mid, left, right)
             + query(node << 1 | 1, mid + 1, end, left, right);
    }

    static void update(int i, int v) {
        int node = i + leafIdx - 1;
        tree[node] += v;

        node >>= 1;
        while (node > 0) {
            tree[node] = tree[node << 1] + tree[node << 1 | 1];
            node >>= 1;
        }
    }
}
