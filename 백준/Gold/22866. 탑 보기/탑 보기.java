import java.io.*;
import java.util.*;

class Main {
    static int N;
    static Building[] buildings;
    static Stack<Building> stack = new Stack<>();

    static class Building {
        int idx;
        int h; 
        int nearIdx;
        int cnt;

        Building(int idx, int h) {
            this.idx = idx;
            this.h = h;
            this.nearIdx = -1;
            this.cnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        buildings = new Building[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            calc(i);
        }

        stack.clear();

        for (int i = N - 1; i >= 0; i--) {
            calc(i);
        }

        StringBuilder sb = new StringBuilder();
        for (Building b : buildings) {
            if (b.cnt == 0) {
                sb.append(0).append("\n");
            } else {
                sb.append(b.cnt).append(" ")
                  .append(b.nearIdx + 1).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void calc(int i) {
        Building cur = buildings[i];

        while (!stack.isEmpty() && stack.peek().h <= cur.h) {
            stack.pop();
        }

        cur.cnt += stack.size();

        if (!stack.isEmpty()) {
            Building prev = stack.peek();

            if (cur.nearIdx == -1) {
                cur.nearIdx = prev.idx;
            } else {
                int d1 = Math.abs(i - prev.idx);
                int d2 = Math.abs(i - cur.nearIdx);

                if (d1 < d2 || (d1 == d2 && prev.idx < cur.nearIdx)) {
                    cur.nearIdx = prev.idx;
                }
            }
        }

        stack.push(cur);
    }
}
