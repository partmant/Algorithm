import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String s = sc.nextLine();
        String[] tokens = s.split(" ");

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }

        Arrays.sort(nums);
        
        System.out.print(nums[n / 2]);
    }
}
