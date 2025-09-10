import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        for(int i=1;i<arr.length;i++)   {
            if(arr[i]!=arr[i-1])
                q.add(arr[i]);
        }
        int[] result = new int[q.size()];
        int i=0;
        while(!q.isEmpty())
            result[i++] = q.poll();
        return result;
    }
}