import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(getResult(x1, y1, r1, x2, y2, r2)).append("\n");
        }

        System.out.print(sb);
    }
    
    private static int getResult(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dx = x1 - x2;
        int dy = y1 - y2;

        double d = Math.sqrt(dx * dx + dy * dy);

        if (d == 0 && r1 == r2) {
            return -1;
        }
        if (d > r1 + r2 || d < Math.abs(r1 - r2) || d == 0 && r1 != r2) {
            return 0;
        }
        if (d == r1 + r2 || d == Math.abs(r1 - r2)) {
            return 1;
        }

        return 2;
    }
}