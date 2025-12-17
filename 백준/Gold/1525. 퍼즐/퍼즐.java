import java.io.*;
import java.util.*;

class Main  {
    static final String TARGET = "123456780";
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                start.append(st.nextToken());
            }
        }
        
        System.out.print(bfs(start.toString()));
    }
    
    static int bfs(String start) {
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> dist = new HashMap<>();
        
        q.add(start);
        dist.put(start, 0);
        
        while (!q.isEmpty()) {
            String now = q.poll();
            int d = dist.get(now);
            
            if (now.equals(TARGET)) {
                return d; 
            }
            
            int zeroIdx = now.indexOf('0');
            int r = zeroIdx / 3;
            int c = zeroIdx % 3;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= 3 || nc < 0 || nc >= 3) {
                    continue;
                }
                
                int nextIdx = nr * 3 + nc;
                
                char[] arr = now.toCharArray();
                arr[zeroIdx] = arr[nextIdx];
                arr[nextIdx] = '0';
                
                String next = new String(arr);
                
                if (!dist.containsKey(next)) {
                    dist.put(next, d + 1);
                    q.add(next);
                }
            }
        }
        
        return -1;
    }
}
