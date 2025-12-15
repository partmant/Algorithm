import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            int M = Integer.parseInt(br.readLine());
            
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            
            sb.append((M / 2) + 1).append("\n");
            
            StringTokenizer st = null;
            int count = 0;
            int printed = 0;
            
            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                
                int n = Integer.parseInt(st.nextToken());
                count++;
                
                if (maxHeap.isEmpty() || n <= maxHeap.peek()) {
                    maxHeap.add(n);
                } else {
                    minHeap.add(n);
                }
                
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                } else if (maxHeap.size() < minHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }                
                
                if (count % 2 == 1) {
                    sb.append(maxHeap.peek()).append(" ");
                    printed++;

                    if (printed % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }
            
            if (printed % 10 != 0) {
                sb.append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
