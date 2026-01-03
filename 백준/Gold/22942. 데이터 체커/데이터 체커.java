import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        List<int[]> Circles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            Circles.add(new int[]{x - r, x + r});
        }
        
        Circles.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int[] now = Circles.get(i);
            
            while (!stack.isEmpty() && stack.peek() < now[0]) {
                stack.pop();
            }
            
            if (!stack.isEmpty() && stack.peek() <= now[1]) {
                System.out.println("NO");
                return;
            }
            
            stack.push(now[1]);
        }
        
        System.out.println("YES");
    }
}
