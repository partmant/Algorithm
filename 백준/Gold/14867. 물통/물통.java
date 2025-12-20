import java.util.*;

class Main {
    static int A, B, C, D;
    static boolean[][] visited;
    static Queue<State> q;
    
    static class State {
        int a, b, cnt;
        
        State(int a, int b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        D = sc.nextInt();
        
        visited = new boolean[A + 1][B + 1];
        q = new ArrayDeque<>();
        
        q.add(new State(0, 0, 0));
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            State now = q.poll();
            
            if (now.a == C && now.b == D) {
                System.out.print(now.cnt);
                return;
            }
            
            // fill
            push(A, now.b, now.cnt);
            push(now.a, B, now.cnt);
            
            // empty
            push(0, now.b, now.cnt);
            push(now.a, 0, now.cnt);
            
            // move
            int amount = Math.min(B - now.b, now.a);
            push(now.a - amount, now.b + amount, now.cnt);
            amount = Math.min(A - now.a, now.b);
            push(now.a + amount, now.b - amount, now.cnt);
        }
        
        System.out.print(-1);
    }
    
    static void push(int a, int b, int cnt) {
        if (!visited[a][b]) {
            visited[a][b] = true;
            q.offer(new State(a, b, cnt + 1));
        }
    }
}
