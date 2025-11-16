import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kingR = king.charAt(1) - '0';
        int kingC = king.charAt(0) - 'A' + 1;

        int stoneR = stone.charAt(1) - '0';
        int stoneC = stone.charAt(0) - 'A' + 1;

        Map<String, int[]> dir = new HashMap<>();
        dir.put("R",  new int[]{0, 1});
        dir.put("L",  new int[]{0, -1});
        dir.put("B",  new int[]{-1, 0});
        dir.put("T",  new int[]{1, 0});
        dir.put("RT", new int[]{1, 1});
        dir.put("LT", new int[]{1, -1});
        dir.put("RB", new int[]{-1, 1});
        dir.put("LB", new int[]{-1, -1});

        while (N-- > 0) {
            String cmd = br.readLine();
            int[] d = dir.get(cmd);

            int nextKingR = kingR + d[0];
            int nextKingC = kingC + d[1];

            if (!inside(nextKingR, nextKingC)) continue;

            if (nextKingR == stoneR && nextKingC == stoneC) {
                int nextStoneR = stoneR + d[0];
                int nextStoneC = stoneC + d[1];

                if (!inside(nextStoneR, nextStoneC)) continue;

                stoneR = nextStoneR;
                stoneC = nextStoneC;
            }

            kingR = nextKingR;
            kingC = nextKingC;
        }

        System.out.println((char) (kingC - 1 + 'A') + "" + kingR);
        System.out.println((char) (stoneC - 1 + 'A') + "" + stoneR);
    }

    static boolean inside(int r, int c) {
        return r >= 1 && r <= 8 && c >= 1 && c <= 8;
    }
}
