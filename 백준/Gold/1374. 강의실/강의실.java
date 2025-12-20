import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] lectures = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new int[]{s , e};  
        }
        
        Arrays.sort(lectures, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] lecture : lectures) {
            if (!pq.isEmpty() && pq.peek() <= lecture[0]) {
                pq.poll();
            }
            pq.offer(lecture[1]);
        }
        
        System.out.print(pq.size());
    }
}
