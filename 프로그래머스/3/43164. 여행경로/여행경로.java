import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> path = new LinkedList<>();
    
    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        
        dfs("ICN");
        
        return path.toArray(new String[0]);
    }
    
    private void dfs(String s) {
        PriorityQueue<String> pq = graph.get(s);
        
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next);
        }
        
        path.addFirst(s);
    }
}
