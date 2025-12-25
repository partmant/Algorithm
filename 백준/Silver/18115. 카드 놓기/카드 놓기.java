import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            dq.add(i);
        }
        
        int[] cards = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = N; i > 0; i--) {
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                cards[dq.poll()] = i;
            } else if (cmd == 2) {
                int prev = dq.poll();
                cards[dq.poll()] = i;
                dq.addFirst(prev);
            } else if (cmd == 3) {
                cards[dq.pollLast()] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : cards) {
            sb.append(i).append(" ");
        }
        
        System.out.print(sb);
    }
} 
