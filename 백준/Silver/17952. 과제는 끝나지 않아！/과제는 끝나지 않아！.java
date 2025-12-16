import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
        int total = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int score = 0;
            int time = 0;
            
            if (cmd == 1) {
                score = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken()) - 1;
            } else {
                if (!stack.isEmpty()) {
                    int[] now = stack.pop();
                    score = now[0];
                    time = now[1] - 1;
                } else {
                    continue;
                }
            }
            
            if (time == 0) {
                total += score;
            } else {
                stack.push(new int[]{score, time});
            }
        }
        
        System.out.print(total);
    }
}
