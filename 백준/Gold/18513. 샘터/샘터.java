import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Set<Long> visited = new HashSet<>();
        Queue<Long> q = new ArrayDeque<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long input = Long.parseLong(st.nextToken());
            q.add(input);
            visited.add(input);
        }
        
        long answer = 0;
        long dist = 1;
        
        while (K > 0) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                long now = q.poll();
                
                if (visited.add(now + 1)) {
                    q.add(now + 1);
                    answer += dist;
                    K--;
                    if (K == 0) break;
                }
                if (visited.add(now - 1)) {
                    q.add(now - 1);
                    answer += dist;
                    K--;
                    if (K == 0) break;
                }
            }
            
            dist++;
        }
     
        System.out.print(answer);
    }
}
