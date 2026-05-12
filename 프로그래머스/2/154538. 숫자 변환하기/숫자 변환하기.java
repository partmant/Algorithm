import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        int[] depth = new int[1000001];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(x);

        while (!q.isEmpty()) {
            int curr = q.poll();
            
            int[] nexts = {curr + n, curr * 2, curr * 3};
            
            for (int next : nexts) {
                if (next == y) {
                	return depth[curr] + 1;
                }
                
                if (next < y && depth[next] == 0) {
                    depth[next] = depth[curr] + 1;
                    q.add(next);
                }
            }
        }
        
        return -1;
    }
}