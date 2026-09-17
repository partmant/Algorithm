import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<List<Integer>> tree = new ArrayList<>();
        int answer = n;
        
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            
            tree.get(from).remove(Integer.valueOf(to));
            tree.get(to).remove(Integer.valueOf(from));
            
            int count = countNodes(tree, 1, n);
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
            
            tree.get(from).add(to);
            tree.get(to).add(from);
        }
        
        return answer;
    }
    
    private int countNodes(List<List<Integer>> tree, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        int cnt = 1;
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : tree.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    cnt++;
                    q.add(next);
                }
            }
        }
        
        return cnt;
    }
}