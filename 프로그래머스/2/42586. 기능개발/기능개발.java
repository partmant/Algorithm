import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++)    
            q.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
                    
        ArrayList<Integer> a = new ArrayList<>();
        int now = q.peek();
        int count=0;
        while(!q.isEmpty())   {
            if(q.peek()<=now)   {
                q.poll();
                count++;
            }
            else {
                a.add(count);
                count=0;
                now = q.peek();
            }            
        }
        a.add(count);
        
        int[] answer = new int[a.size()];
        for(int i=0;i<a.size();i++)
            answer[i] = a.get(i);
        
        return answer;
    }
}