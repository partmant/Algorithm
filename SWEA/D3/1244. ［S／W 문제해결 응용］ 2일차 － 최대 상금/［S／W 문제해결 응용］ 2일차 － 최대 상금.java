import java.util.*;
import java.io.*;

class Solution
{
    static int swapLimit;
    static int result;
    static Set<String> visited;
    
	public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String nums = sc.next();
            swapLimit = sc.nextInt();
            result = 0;
            visited = new HashSet<>();
            
            dfs(nums.toCharArray(), 0);
            
            System.out.println("#" + test_case + " " + result);
		}
	}
    
    static void dfs(char[] nums, int depth)	{
        if(depth==swapLimit)	{
        	result = Math.max(result, Integer.parseInt(new String(nums)));
            return;
        }
        
        String key = new String(nums) + "-" + depth;
        if(visited.contains(key)) return;
        visited.add(key);
            
        for(int i = 0; i < nums.length - 1; i++)	{
            for(int j = i + 1; j < nums.length; j++)	{
            	swap(nums, i, j);
                dfs(nums, depth + 1);
                swap(nums, i, j);
            }
        }
    }
    
    static void swap(char[] nums, int index1, int index2)	{
    	char temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}