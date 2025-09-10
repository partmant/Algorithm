import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<bridge_length;i++)
            q.add(0);
        
        int num = 0, current_weight=0, time=0;  
        while(!(num==truck_weights.length&&current_weight==0)) {
            time++;
            current_weight-=q.poll();
            
            if(num<truck_weights.length)    {
                if(current_weight+truck_weights[num]<=weight) {
                    current_weight+=truck_weights[num];
                    q.add(truck_weights[num++]);
                }
                else
                    q.add(0);
            }
        } 
        return time;
    }
}