import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] op = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = sc.nextInt();

        for (int i = 0; i < 4; i++)
            op[i] = sc.nextInt();

        dfs(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }
    
    static void dfs(int idx, int value) {
        if (idx == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }
        if (op[0] > 0) {
            op[0]--;
            dfs(idx + 1, value + nums[idx]);
            op[0]++;
        } 
        if (op[1] > 0) {
            op[1]--;
            dfs(idx + 1, value - nums[idx]);
            op[1]++;
        } 
        if (op[2] > 0) {
            op[2]--;
            dfs(idx + 1, value * nums[idx]);
            op[2]++;
        } 
        if (op[3] > 0) {
            op[3]--;
            dfs(idx + 1, value / nums[idx]);
            op[3]++;
        }
    }
}