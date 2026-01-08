import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> visited = new HashSet<>();
    static char[] nums;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        length = s.length();
        nums = s.toCharArray();

        for (int i = 0; i < length; i++) {
            dfs("" + nums[i] + "|", i, i);
        }

        System.out.print(visited.size());
    }

    static void dfs(String path, int lIdx, int rIdx) {
        if (lIdx == 0 && rIdx == length - 1) {
            visited.add(path);
            return;
        }

        if (rIdx + 1 < length) {
            String next = String.valueOf(nums, lIdx, rIdx - lIdx + 2);
            dfs(path + next + "|", lIdx, rIdx + 1);
        }

        if (lIdx - 1 >= 0) {
            String next = String.valueOf(nums, lIdx - 1, rIdx - lIdx + 2);
            dfs(path + next + "|", lIdx - 1, rIdx);
        }
    }
}
