import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            max[i] = num;
            min[i] = num;
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] newMax = new int[3];
            int[] newMin = new int[3];

            newMax[0] = l + Math.max(max[0], max[1]);
            newMax[1] = m + Math.max(max[0], Math.max(max[1], max[2]));
            newMax[2] = r + Math.max(max[1], max[2]);

            newMin[0] = l + Math.min(min[0], min[1]);
            newMin[1] = m + Math.min(min[0], Math.min(min[1], min[2]));
            newMin[2] = r + Math.min(min[1], min[2]);

            max = newMax;
            min = newMin;
        }

        int maxV = Math.max(max[0], Math.max(max[1], max[2]));
        int minV = Math.min(min[0], Math.min(min[1], min[2]));

        System.out.println(maxV + " " + minV);
    }
}
