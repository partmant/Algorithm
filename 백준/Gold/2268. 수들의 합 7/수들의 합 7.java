import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static long[] tree;
    static int leafIdx;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        leafIdx = 1;
        while (leafIdx < N) {
            leafIdx *= 2;
        }
        
        tree = new long[leafIdx * 2]; 
        
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            
            if (cmd == 0) {
                int i = Math.min(input1, input2);
                int j = Math.max(input1, input2);
                sb.append(query(1, 1, leafIdx, i, j)).append("\n");
            } else if (cmd == 1) {
                modify(input1, input2);
            }
        }
        
        System.out.print(sb);
    }
    
    static long query(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return 0;
        if (start >= left && end <= right) return tree[node];
        
        int mid = (start + end) / 2;
        
        return query(node * 2, start, mid, left, right) 
            + query(node * 2 + 1, mid + 1, end, left, right);
    }
    
    static void modify(int node, int value) {
        int idx = leafIdx + node - 1;
        tree[idx] = value;
        
        while (idx > 1) {
            idx /= 2;
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
        }
    }
}
