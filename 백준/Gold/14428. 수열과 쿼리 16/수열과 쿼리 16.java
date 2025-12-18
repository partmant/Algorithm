import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] tree;
    static int leafIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        leafIdx = 1;
        while (leafIdx < N) {
            leafIdx *= 2;
        }

        tree = new int[leafIdx * 2];

        arr = new int[leafIdx + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= leafIdx; i++) {
            tree[leafIdx + i - 1] = i;
        }

        for (int i = leafIdx - 1; i > 0; i--) {
            int l = tree[i * 2];
            int r = tree[i * 2 + 1];
            if (arr[l] <= arr[r]) {
                tree[i] = l;
            }
            else tree[i] = r;
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                update(a, b);
            } else {
                int result = query(1, 1, leafIdx, a, b);
                sb.append(result).append('\n');
            }
        }

        System.out.print(sb);
    }

    static int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return -1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) >> 1;
        int l = query(node * 2, start, mid, left, right);
        int r = query(node * 2 + 1, mid + 1, end, left, right);

        if (l == -1) return r;
        if (r == -1) return l;
        return (arr[l] <= arr[r]) ? l : r;
    }

    static void update(int idx, int value) {
        arr[idx] = value;
        int node = leafIdx + idx - 1;
        tree[node] = idx;

        node /= 2;
        while (node > 0) {
            int l = tree[node * 2];
            int r = tree[node * 2 + 1];
            tree[node] = (arr[l] <= arr[r]) ? l : r;
            node >>= 1;
        }
    }
}
