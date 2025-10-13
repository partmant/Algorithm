import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int n = Integer.parseInt(br.readLine());
            int[] buildings = new int[n];
            int result = 0;
		   	
            StringTokenizer st = new StringTokenizer(br.readLine());
			
            for(int i = 0; i< n; i++)	{
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 2; i < n-2; i++)	{
            	int leftMax = Math.max(buildings[i-2], buildings[i-1]);
                int rightMax = Math.max(buildings[i+2], buildings[i+1]);
                int max = Math.max(leftMax, rightMax);
                
                if(buildings[i] > max)	{
                	result += buildings[i] - max;   
                }
            }
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}