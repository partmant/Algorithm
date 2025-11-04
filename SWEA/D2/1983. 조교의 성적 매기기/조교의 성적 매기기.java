import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            double[] scores = new double[N];
            Integer[] indexArr = new Integer[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int task = Integer.parseInt(st.nextToken());

                scores[i] = mid * 0.35 + fin * 0.45 + task * 0.2;
                indexArr[i] = i;
            }

            Arrays.sort(indexArr, (a, b) -> Double.compare(scores[b], scores[a]));

            int studentsPerGrade = N / 10;
            Map<Integer, String> gradeMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                int idx = indexArr[i];
                int gradeIdx = i / studentsPerGrade;
                gradeMap.put(idx, grades[gradeIdx]);
            }

            sb.append("#").append(t).append(" ").append(gradeMap.get(K - 1)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
