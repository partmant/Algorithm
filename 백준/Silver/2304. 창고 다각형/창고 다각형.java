import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] board = new int[1001];
        int maxH = 0;
        int maxL = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            board[l] = h;

            if (h > maxH) {
                maxH = h;
                maxL = l;
            }
        }

        int area = 0;
        
        int leftMax = 0;
        for (int i = 0; i <= maxL; i++) {
            leftMax = Math.max(leftMax, board[i]);
            area += leftMax;
        }

        int rightMax = 0;
        for (int i = 1000; i >= maxL; i--) {
            rightMax = Math.max(rightMax, board[i]);
            area += rightMax;
        }

        area -= board[maxL];

        System.out.println(area);
    }
}
