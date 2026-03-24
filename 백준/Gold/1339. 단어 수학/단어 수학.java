import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] weight = new int[26];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int place = 1;

            for (int j = word.length() - 1; j >= 0; j--) {
                char ch = word.charAt(j);
                weight[ch - 'A'] += place;
                place *= 10;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (weight[i] > 0) {
                list.add(weight[i]);
            }
        }

        list.sort(Collections.reverseOrder());

        int num = 9;
        int answer = 0;

        for (int w : list) {
            answer += w * num;
            num--;
        }

        System.out.println(answer);
    }
}
