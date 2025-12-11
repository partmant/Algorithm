import java.io.*;
import java.util.*;

class Main {
    static long[] tree;
    static int leafIndex;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        leafIndex = 1;
        while (leafIndex < N) {
            leafIndex <<= 1;
        }
        
        tree = new long[leafIndex * 2];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[leafIndex + i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = leafIndex - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
        
        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int left = Math.min(x, y);
            int right = Math.max(x, y);
            
            long sum = query(1, 1, leafIndex, left, right);
            sb.append(sum).append("\n");
            
            update(a, b);
        }
        
        System.out.print(sb);
    }
    
    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right)
             + query(node * 2 + 1, mid + 1, end, left, right);
    }

    static void update(int idx, long value) {
        int node = leafIndex + idx - 1;
        tree[node] = value;

        node /= 2;
        while (node > 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }
}
