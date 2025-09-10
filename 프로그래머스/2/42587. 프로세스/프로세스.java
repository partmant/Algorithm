import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i=0;i<priorities.length;i++)   {
            q.add(new int[]{i,priorities[i]});            
            max.add(priorities[i]);
        }

        int order=0;
        while(!q.isEmpty()) {
            if(q.peek()[1]==max.peek())    {
                max.poll();
                order++;
                if(q.poll()[0]==location)
                    return order;                
            }
            else    {
                q.add(q.poll());
            } 
        }
        return order;
    }
}