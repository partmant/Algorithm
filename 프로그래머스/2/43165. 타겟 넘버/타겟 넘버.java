import java.util.*;
class Solution {
    static int result;
    
    public static int solution(int[] numbers, int target)  {
        dfs(numbers, 0, 0, target);
        
        return result;
    }
    public static void dfs(int[] numbers, int depth, int sum, int target)   {
        if(depth==numbers.length)   {
            if(sum==target)
                result++;
            return;
        }
        dfs(numbers, depth+1, sum+numbers[depth], target);
        dfs(numbers, depth+1, sum-numbers[depth], target);
    }
}