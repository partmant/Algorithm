import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        StringBuilder[] builders = new StringBuilder[C];
        for (int i = 0; i < C; i++) {
            builders[i] = new StringBuilder();
        }

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                builders[c].append(line.charAt(c));
            }
        }

        String[] columns = new String[C];
        for (int c = 0; c < C; c++) {
            columns[c] = builders[c].toString();
        }

        int answer = 0;

        for (int cut = 0; cut < R; cut++) {
            Set<String> set = new HashSet<>();
            boolean duplicated = false;

            for (int c = 0; c < C; c++) {
                String sub = columns[c].substring(cut);
                if (!set.add(sub)) {
                    duplicated = true;
                    break;
                }
            }

            if (duplicated) break;
            answer++;
        }

        System.out.println(answer - 1);
    }
}
