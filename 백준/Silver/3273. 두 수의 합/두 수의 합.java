import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nums);
        
        int target = Integer.parseInt(br.readLine());
        int lIndex = 0;
        int rIndex = N - 1;
        int result = 0;
        
        while (rIndex > lIndex) {
            if (nums[lIndex] + nums[rIndex] > target) {
                rIndex--;
            } else if (nums[lIndex] + nums[rIndex] < target) {
                lIndex++;
            } else {
                result++;
                lIndex++;
                rIndex--;
            }
        }
        
        System.out.print(result);
    }
}