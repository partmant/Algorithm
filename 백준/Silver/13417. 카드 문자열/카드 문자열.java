import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            Deque<Character> dq = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < N; i++) {
                char now = st.nextToken().charAt(0);
                
                if (dq.isEmpty()) {
                    dq.add(now);
                } else {
                    if (now <= dq.peekFirst()) {
                        dq.addFirst(now);
                    } else {
                        dq.addLast(now);
                    }
                }
            }
            
            for (char c : dq) {
                sb.append(c);
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
