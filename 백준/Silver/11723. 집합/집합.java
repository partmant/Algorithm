import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] set = new boolean[21];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            switch (type) {
                case "add":
                    set[Integer.parseInt(st.nextToken())] = true;
                    break;

                case "remove":
                    set[Integer.parseInt(st.nextToken())] = false;
                    break;

                case "check":
                    int v1 = Integer.parseInt(st.nextToken());
                    bw.write(set[v1] ? "1\n" : "0\n");
                    break;

                case "toggle":
                    int v2 = Integer.parseInt(st.nextToken());
                    set[v2] = !set[v2];
                    break;

                case "all":
                    Arrays.fill(set, true);
                   break;

                case "empty":
                    Arrays.fill(set, false);
                    break;
            }
        }

        bw.flush();
    }
}